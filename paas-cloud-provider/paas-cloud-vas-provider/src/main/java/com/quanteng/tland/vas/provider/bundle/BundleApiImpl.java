/**
 * 文 件 名:  BundleApiImpl
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.provider.bundle;

import com.google.common.collect.Lists;
import com.quanteng.tland.cms.pojo.bundle.domain.BundleVo;
import com.quanteng.tland.cms.pojo.bundle.request.QueryBundleConditionRequest;
import com.quanteng.tland.common.annotation.Api;
import com.quanteng.tland.common.cons.Constants;
import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.vas.api.bundle.BundleApi;
import com.quanteng.tland.vas.pojo.bundle.domain.BundleDto;
import com.quanteng.tland.vas.pojo.bundle.request.SearchBundleByIdRequest;
import com.quanteng.tland.vas.provider.ads.AdsApiImpl;
import com.quanteng.tland.vas.service.bundle.BundleServcie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.quanteng.tland.common.log.TlandLogger.*;

/**
 * <套餐接口定义实现类>
 *
 * @author LJun
 * @version 2018/5/15
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

@Api
public class BundleApiImpl implements BundleApi
{
	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (AdsApiImpl.class);

	@Autowired
	private BundleServcie bundleServcie;

	/**
	 * 根据套餐编号查询套餐信息 供客户端使用
	 *
	 * @param searchBundleByIdRequest
	 * @return
	 */
	@Override
	public Result<BundleDto> findBundleById (SearchBundleByIdRequest searchBundleByIdRequest)
	{
		if (null == searchBundleByIdRequest)
		{
			return new Result<BundleDto> ().failure ("findBundleById illegal params");
		}
		//查询cms
		Result<BundleVo> serviceResult = bundleServcie.findBundleById (searchBundleByIdRequest.getBundleId ());
		//返回响应定义
		Result<BundleDto> result = new Result<BundleDto> ();
		BundleDto bundleDto = new BundleDto ();
		//实体转换
		BeanUtils.copyProperties (serviceResult.getData (), bundleDto);

		return new Result<> ().success (bundleDto);
	}

	/**
	 * 多条件查询套餐信息
	 *
	 * @return
	 */
	@Override
	public Result<List<BundleDto>> queryBundlesList ()
	{
		i ("BUNDLE", "queryBundlesList", LOG_TYPE_REQUEST, "begin");
		//构造cms请求
		QueryBundleConditionRequest queryBundleConditionRequest = new QueryBundleConditionRequest ();
		//查询Cms
		Result<List<BundleVo>> serviceResult = bundleServcie.queryBundlesByCondition (queryBundleConditionRequest);

		Result<List<BundleDto>> result = new Result<List<BundleDto>> ();
		List<BundleDto> bundleDtoList = Lists.newArrayList ();
		//转换cms返回信息
		if (null != serviceResult && (Constants.ResultCode.SUCCESS).equals (serviceResult.getResultCode ()))
		{
			if (! CollectionUtils.isEmpty (serviceResult.getData ()))
			{
				List<BundleVo> bundleVoList = serviceResult.getData ();
				bundleVoList.forEach (bundle -> {
					BundleDto bundleDto = new BundleDto ();
					BeanUtils.copyProperties (bundle, bundleDto);
					bundleDtoList.add (bundleDto);
				});
				result.success (bundleDtoList);
				result.setTotalCount (serviceResult.getTotalCount ());
			}
		}
		else
		{
			result.setResultMessage ("queryBundlesList CMSServcis Return Data Is Null Or ReturnCode No Zero");
		}

		i ("BUNDLE", "queryBundlesList", LOG_TYPE_RESPONSE, result);
		return result;
	}
}
