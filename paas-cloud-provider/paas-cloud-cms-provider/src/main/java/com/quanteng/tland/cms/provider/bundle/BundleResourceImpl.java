/**
 * 文 件 名:  BundleResourceImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/4 0004
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.bundle;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.quanteng.tland.cms.api.bundle.BundleResource;
import com.quanteng.tland.cms.database.entity.Bundle;
import com.quanteng.tland.cms.database.entity.BundleLang;
import com.quanteng.tland.cms.database.mapper.BundleMapper;
import com.quanteng.tland.cms.pojo.bundle.domain.BundleLangVo;
import com.quanteng.tland.cms.pojo.bundle.domain.BundleVo;
import com.quanteng.tland.cms.pojo.bundle.request.CreateBundleRequest;
import com.quanteng.tland.cms.pojo.bundle.request.ModifyBundleRequest;
import com.quanteng.tland.cms.pojo.bundle.request.QueryBundleConditionRequest;
import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.common.thread.Language;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.quanteng.tland.common.cons.Constants.Cons.*;
import static com.quanteng.tland.common.log.TlandLogger.*;

/**
 * <套餐接口实现>
 *
 * @author zping
 * @version 2018/5/4 0004
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class BundleResourceImpl implements BundleResource
{

	@Autowired
	private BundleMapper bundleMapper;

	/**
	 * 创建套餐
	 *
	 * @param createBundleRequest
	 * @return
	 */
	@Override
	public Result createBundle (@RequestBody CreateBundleRequest createBundleRequest)
	{
		if (null == createBundleRequest || null == createBundleRequest.getBundle ())
		{
			return new Result<String> ().failure ("illega params");
		}
		i ("BUNDLE", "createBundle", LOG_TYPE_REQUEST, createBundleRequest);
		BundleVo bundleVo = createBundleRequest.getBundle ();
		List<BundleLangVo> bundleLangVos = bundleVo.getBundleLangs ();
		Bundle bundle = new Bundle ();
		BeanUtils.copyProperties (bundleVo, bundle);
		int flag = bundleMapper.createBundle (bundle);
		i ("BUNDLE", "createBundle", LOG_TYPE_RESPONSE, flag);
		if (0 < flag)
		{
			if (! CollectionUtils.isEmpty (bundleLangVos))
			{
				List<BundleLang> bundles = Lists.newArrayList ();
				bundleLangVos.forEach (bundleLangVo -> {
					BundleLang bundleTemp = new BundleLang ();
					BeanUtils.copyProperties (bundleLangVo, bundleTemp);
					bundles.add (bundleTemp);
				});
				flag = bundleMapper.addBundleLang (bundles);
				if (0 < flag)
				{
					return new Result ().success ();
				}
				else
				{
					return new Result ().failure ("add bundle failed.");
				}
			}
			else
			{
				return new Result ().success ();
			}
		}
		else
		{
			return new Result ().failure ("add bundle failed.");
		}
	}

	/**
	 * 修改套餐
	 *
	 * @param modifyBundleRequest
	 * @return
	 */
	@Override
	public Result modifyBundle (@RequestBody ModifyBundleRequest modifyBundleRequest)
	{
		if (null == modifyBundleRequest || null == modifyBundleRequest.getBundle ())
		{
			return new Result<String> ().failure ("illega params");
		}
		i ("BUNDLE", "modifyBundle", LOG_TYPE_REQUEST, modifyBundleRequest);
		BundleVo bundleVo = modifyBundleRequest.getBundle ();
		List<BundleLangVo> bundleLangVos = bundleVo.getBundleLangs ();
		Bundle bundle = new Bundle ();
		BeanUtils.copyProperties (bundleVo, bundle);
		int flag = bundleMapper.modifyBundle (bundle);
		i ("BUNDLE", "modifyBundle", LOG_TYPE_RESPONSE, flag);
		if (0 < flag)
		{
			if (! CollectionUtils.isEmpty (bundleLangVos))
			{
				List<BundleLang> bundleLangs = Lists.newArrayList ();
				bundleLangVos.forEach (bundleLangVo -> {
					BundleLang bundleTemp = new BundleLang ();
					BeanUtils.copyProperties (bundleLangVo, bundleTemp);
					bundleLangs.add (bundleTemp);
				});
				flag = bundleMapper.modifyBundleLang (bundleLangs);
				if (0 < flag)
				{
					return new Result ().success ();
				}
				else
				{
					return new Result ().failure ("add bundle failed.");
				}
			}
			else
			{
				return new Result ().success ();
			}
		}
		else
		{
			return new Result ().failure ("add bundle failed.");
		}
	}

	/**
	 * 根据套餐编号查询套餐信息 供平台使用
	 *
	 * @param bundleId
	 * @return
	 */
	@Override
	public Result<BundleVo> findBundleById (@PathVariable ("bundleId") String bundleId)
	{
		if (StringUtils.isEmpty (bundleId))
		{
			return new Result<BundleVo> ().failure ("bundleId is empty");
		}
		i ("BUNDLE", "findBundleById", LOG_TYPE_REQUEST, bundleId);
		Bundle bundle = bundleMapper.findPackageById (bundleId);
		i ("BUNDLE", "findBundleById", LOG_TYPE_RESPONSE, bundle);
		if (null != bundle)
		{
			BundleVo bundleVo = new BundleVo ();
			BeanUtils.copyProperties (bundle, bundleVo);
			List<BundleLang> bundleLangs = bundleMapper.findPackageLangById (bundleId);
			if (! CollectionUtils.isEmpty (bundleLangs))
			{
				List<BundleLangVo> bundleLangVos = Lists.newArrayList ();
				BundleLangVo bundleLangVo = null;
				for (BundleLang bundleLang : bundleLangs)
				{
					bundleLangVo = new BundleLangVo ();
					BeanUtils.copyProperties (bundleLang, bundleLangVo);
					bundleLangVos.add (bundleLangVo);
				}
				bundleVo.setBundleLangs (bundleLangVos);
			}
			return new Result<BundleVo> ().success (bundleVo);
		}
		else
		{
			Result result = new Result<BundleVo> ();
			result.setResultMessage ("bundle not exist");
			return result;
		}
	}

	/**
	 * 根据套餐编号查询套餐信息 供客户端使用
	 *
	 * @param bundleId
	 * @return
	 */
	@Override
	public Result<BundleVo> queryBundleById (@PathVariable ("bundleId") String bundleId)
	{
		if (StringUtils.isEmpty (bundleId))
		{
			return new Result<BundleVo> ().failure ("bundleId is empty");
		}
		i ("BUNDLE", "queryBundleById", LOG_TYPE_REQUEST, bundleId);
		Bundle bundle = bundleMapper.queryPackageById (bundleId, Language.getLanguage ());
		i ("BUNDLE", "queryBundleById", LOG_TYPE_RESPONSE, bundle);
		if (null != bundle)
		{
			BundleVo bundleVo = new BundleVo ();
			BeanUtils.copyProperties (bundle, bundleVo);
			return new Result<BundleVo> ().success (bundleVo);
		}
		else
		{
			Result result = new Result<BundleVo> ();
			result.setResultMessage ("bundle not exist");
			return result;
		}
	}

	/**
	 * 多条件查询套餐信息
	 *
	 * @param queryBundleConditionRequest
	 * @return
	 */
	@Override
	public Result<List<BundleVo>> queryBundlesByCondition (
			@RequestBody QueryBundleConditionRequest queryBundleConditionRequest)
	{
		Result<List<BundleVo>> result = new  Result<List<BundleVo>>();
		Map<String, Object> params = Maps.newHashMap ();

		if (! StringUtils.isEmpty (queryBundleConditionRequest.getBundleName ()))
		{
			params.put ("bundleName", queryBundleConditionRequest.getBundleName ());
		}

		if (! StringUtils.isEmpty (queryBundleConditionRequest.getBundleType ()))
		{
			params.put ("bundleType", queryBundleConditionRequest.getBundleType ());
		}
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());
		params.put (DATA_PAGE_START, queryBundleConditionRequest.getPageIndex ());
		params.put (DATA_PAGE_SIZE, queryBundleConditionRequest.getPageSize ());

		i ("BUNDLE", "queryBundlesByCondition", LOG_TYPE_REQUEST, params);
		List<Bundle> bundles = bundleMapper.queryBundlesByCondition (params);
		i ("BUNDLE", "queryBundlesByCondition", LOG_TYPE_RESPONSE, bundles);

		if (! CollectionUtils.isEmpty (bundles))
		{
			List<BundleVo> bundleVos = Lists.newArrayList ();
			BundleVo bundleVo = null;
			for (Bundle bundle : bundles)
			{
				bundleVo = new BundleVo ();
				BeanUtils.copyProperties (bundle, bundleVo);
				bundleVos.add (bundleVo);
			}
			result.setData (bundleVos);
			result.setTotalCount (bundleMapper.queryBundlesCountByCondition (params));
		}
		result.success ();
		return result;
	}

	/**
	 * 删除套餐信息
	 *
	 * @param bundleId
	 * @return
	 */
	@Override
	public Result deleteBundle (@PathVariable ("bundleId") String bundleId)
	{
		if (StringUtils.isEmpty (bundleId))
		{
			return new Result<BundleVo> ().failure ("bundleId is empty");
		}
		i ("BUNDLE", "deleteBundle", LOG_TYPE_REQUEST, bundleId);
		int flag = bundleMapper.deleteBundle (bundleId);
		i ("BUNDLE", "deleteBundle", LOG_TYPE_RESPONSE, flag);
		if (0 < flag)
		{
			int temp = bundleMapper.deleteBundleLang (bundleId);
			if (0 < temp)
			{
				return new Result ().success ();
			}
			else
			{
				return new Result ().failure ("delete bundleLangs failed.");
			}

		}
		else
		{
			return new Result ().failure ("delete bundle failed.");
		}
	}
}
