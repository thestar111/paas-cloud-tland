/**
 * 文 件 名:  BundleAppOrCatalogRelationResourceImpl
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2018/5/15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.bundleapporcatalogrelation;

import com.google.common.collect.Lists;
import com.quanten.core.utils.GenerateSequenceID;
import com.quanteng.tland.cms.api.bundleapporcatalogrelation.BundleAppOrCatalogRelationResource;
import com.quanteng.tland.cms.database.entity.BundleAppOrCatalogRelation;
import com.quanteng.tland.cms.database.mapper.BundleAppOrCatalogRelationMapper;
import com.quanteng.tland.cms.pojo.bundleapporcatalogrelation.domain.BundleAppOrCatalogRelationVo;
import com.quanteng.tland.cms.pojo.bundleapporcatalogrelation.request.*;
import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.common.thread.Language;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.quanteng.tland.common.cons.Constants.Cons.DATA_LOCAL_LANGUAGE;
import static com.quanteng.tland.common.cons.Constants.Cons.DATA_PAGE_SIZE;
import static com.quanteng.tland.common.cons.Constants.Cons.DATA_PAGE_START;
import static com.quanteng.tland.common.log.TlandLogger.LOG_TYPE_REQUEST;
import static com.quanteng.tland.common.log.TlandLogger.i;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <套餐应用配置资源接口实现>
 *
 * @author zhengbinggui
 * @version 2018/5/15
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class BundleAppOrCatalogRelationResourceImpl implements BundleAppOrCatalogRelationResource
{
	@Autowired
	private BundleAppOrCatalogRelationMapper bundleAppOrCatalogRelationMapper;

	/**
	 * 批量新增套餐应用或栏目关系
	 *
	 * @param batchAddBundleAppOrCatalogRelationRequest
	 * @return
	 */
	@Override
	public Result batchAdd (
			@RequestBody BatchAddBundleAppOrCatalogRelationRequest batchAddBundleAppOrCatalogRelationRequest)
	{
		if (null == batchAddBundleAppOrCatalogRelationRequest || CollectionUtils
				.isEmpty (batchAddBundleAppOrCatalogRelationRequest.getBundleAppOrCatalogRelationVos ()))
		{
			return new Result ().failure ("illega params");
		}

		i ("BUNDLEAPPORCATALOGRELATION", "batchAdd", LOG_TYPE_REQUEST, batchAddBundleAppOrCatalogRelationRequest);

		List<BundleAppOrCatalogRelation> bundleAppOrCatalogRelations = Lists.newArrayList ();
		batchAddBundleAppOrCatalogRelationRequest.getBundleAppOrCatalogRelationVos ()
				.forEach (bundleAppOrCatalogRelationVo -> {
					BundleAppOrCatalogRelation bundleAppOrCatalogRelation = new BundleAppOrCatalogRelation ();
					String id = GenerateSequenceID.getSeqID ();
					BeanUtils.copyProperties (bundleAppOrCatalogRelationVo, bundleAppOrCatalogRelation);
					bundleAppOrCatalogRelation.setId (id);
					bundleAppOrCatalogRelations.add (bundleAppOrCatalogRelation);
				});
		int flag = bundleAppOrCatalogRelationMapper.batchAdd (bundleAppOrCatalogRelations);
		if (0 < flag)
		{
			return new Result ().success ();
		}
		else
		{
			return new Result ().failure ("add bundleAppOrCatalogRelation failed.");
		}
	}

	/**
	 * 批量删除套餐应用或栏目关系
	 *
	 * @param batchDeleteBundleAppOrCatalogRelationByIdRequest
	 * @return
	 */
	@Override
	public Result batchDelete (
			@RequestBody BatchDeleteBundleAppOrCatalogRelationByIdRequest batchDeleteBundleAppOrCatalogRelationByIdRequest)
	{
		if (null == batchDeleteBundleAppOrCatalogRelationByIdRequest || CollectionUtils
				.isEmpty (batchDeleteBundleAppOrCatalogRelationByIdRequest.getIds ()))
		{
			return new Result ().failure ("illega params");
		}

		i ("BUNDLEAPPORCATALOGRELATION", "batchDelete", LOG_TYPE_REQUEST,
				batchDeleteBundleAppOrCatalogRelationByIdRequest);

		int flag = bundleAppOrCatalogRelationMapper
				.batchDelete (batchDeleteBundleAppOrCatalogRelationByIdRequest.getIds ());

		if (0 < flag)
		{
			return new Result ().success ();
		}
		else
		{
			return new Result ().failure ("delete bundleAppOrCatalogRelation failed.");
		}
	}

	/**
	 * 查询套餐中的应用
	 *
	 * @param queryAppInBundleRequest
	 * @return
	 */
	@Override
	public Result<List<BundleAppOrCatalogRelationVo>> queryAppInBundle (
			@RequestBody QueryAppInBundleRequest queryAppInBundleRequest)
	{
		if (null == queryAppInBundleRequest)
		{
			return new Result ().failure ("illega params");
		}

		i ("BUNDLEAPPORCATALOGRELATION", "queryAppInBundle", LOG_TYPE_REQUEST, queryAppInBundleRequest);

		Result<List<BundleAppOrCatalogRelationVo>> result = new Result<> ();

		Map<String, Object> params = new HashMap<> ();
		if (! StringUtils.isEmpty (queryAppInBundleRequest.getCatalogId ()))
		{
			params.put ("appColumn", queryAppInBundleRequest.getCatalogId ());
		}
		if (! StringUtils.isEmpty (queryAppInBundleRequest.getAppName ()))
		{
			params.put ("appName", queryAppInBundleRequest.getAppName ());
		}
		if (! StringUtils.isEmpty (queryAppInBundleRequest.getPackageId ()))
		{
			params.put ("packageId", queryAppInBundleRequest.getPackageId ());
		}
		if (null != queryAppInBundleRequest.getPageIndex () && null != queryAppInBundleRequest.getPageSize ())
		{
			params.put (DATA_PAGE_START,
					(queryAppInBundleRequest.getPageIndex () - 1) * queryAppInBundleRequest.getPageSize ());
			params.put (DATA_PAGE_SIZE, queryAppInBundleRequest.getPageSize ());
		}
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());

		List<BundleAppOrCatalogRelation> bundleAppOrCatalogRelations = bundleAppOrCatalogRelationMapper
				.queryAppInBundle (params);

		if (! CollectionUtils.isEmpty (bundleAppOrCatalogRelations))
		{
			List<BundleAppOrCatalogRelationVo> bundleAppOrCatalogRelationVos = Lists.newArrayList ();
			bundleAppOrCatalogRelations.forEach (bundleAppOrCatalogRelation -> {
				BundleAppOrCatalogRelationVo bundleAppOrCatalogRelationVo = new BundleAppOrCatalogRelationVo ();
				BeanUtils.copyProperties (bundleAppOrCatalogRelation, bundleAppOrCatalogRelationVo);
				bundleAppOrCatalogRelationVos.add (bundleAppOrCatalogRelationVo);
			});
			result.setData (bundleAppOrCatalogRelationVos);
			result.setTotalCount (bundleAppOrCatalogRelationMapper.countAppInBundle (params));
		}
		result.success ();
		return result;
	}

	/**
	 * 查询不在套餐中的应用
	 *
	 * @param queryAppNotInBundleRequest
	 * @return
	 */
	@Override
	public Result<List<BundleAppOrCatalogRelationVo>> queryAppNotInBundle (
			@RequestBody QueryAppNotInBundleRequest queryAppNotInBundleRequest)
	{
		if (null == queryAppNotInBundleRequest)
		{
			return new Result ().failure ("illega params");
		}

		i ("BUNDLEAPPORCATALOGRELATION", "queryAppNotInBundle", LOG_TYPE_REQUEST, queryAppNotInBundleRequest);

		Result<List<BundleAppOrCatalogRelationVo>> result = new Result<> ();

		Map<String, Object> params = new HashMap<> ();
		if (! StringUtils.isEmpty (queryAppNotInBundleRequest.getCatalogId ()))
		{
			params.put ("appColumn", queryAppNotInBundleRequest.getCatalogId ());
		}
		if (! StringUtils.isEmpty (queryAppNotInBundleRequest.getAppName ()))
		{
			params.put ("appName", queryAppNotInBundleRequest.getAppName ());
		}
		if (! StringUtils.isEmpty (queryAppNotInBundleRequest.getPackageId ()))
		{
			params.put ("packageId", queryAppNotInBundleRequest.getPackageId ());
		}
		if (null != queryAppNotInBundleRequest.getPageIndex () && null != queryAppNotInBundleRequest.getPageSize ())
		{
			params.put (DATA_PAGE_START,
					(queryAppNotInBundleRequest.getPageIndex () - 1) * queryAppNotInBundleRequest.getPageSize ());
			params.put (DATA_PAGE_SIZE, queryAppNotInBundleRequest.getPageSize ());
		}
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());

		List<BundleAppOrCatalogRelation> bundleAppOrCatalogRelations = bundleAppOrCatalogRelationMapper
				.queryAppNotInBundle (params);

		if (! CollectionUtils.isEmpty (bundleAppOrCatalogRelations))
		{
			List<BundleAppOrCatalogRelationVo> bundleAppOrCatalogRelationVos = Lists.newArrayList ();
			bundleAppOrCatalogRelations.forEach (bundleAppOrCatalogRelation -> {
				BundleAppOrCatalogRelationVo bundleAppOrCatalogRelationVo = new BundleAppOrCatalogRelationVo ();
				BeanUtils.copyProperties (bundleAppOrCatalogRelation, bundleAppOrCatalogRelationVo);
				bundleAppOrCatalogRelationVos.add (bundleAppOrCatalogRelationVo);
			});
			result.setData (bundleAppOrCatalogRelationVos);
			result.setTotalCount (bundleAppOrCatalogRelationMapper.countAppNotInBundle (params));
		}
		result.success ();
		return result;
	}

	/**
	 * 查询套餐中的栏目
	 *
	 * @param queryCatalogInBundleRequest
	 * @return
	 */
	@Override
	public Result<List<BundleAppOrCatalogRelationVo>> queryCatalogInBundle (
			@RequestBody QueryCatalogInBundleRequest queryCatalogInBundleRequest)
	{
		if (null == queryCatalogInBundleRequest)
		{
			return new Result ().failure ("illega params");
		}

		i ("BUNDLEAPPORCATALOGRELATION", "queryCatalogInBundle", LOG_TYPE_REQUEST, queryCatalogInBundleRequest);

		Result<List<BundleAppOrCatalogRelationVo>> result = new Result<> ();
		Map<String, Object> params = new HashMap<> ();
		if (! StringUtils.isEmpty (queryCatalogInBundleRequest.getPackageId ()))
		{
			params.put ("packageId", queryCatalogInBundleRequest.getPackageId ());
		}
		if (null != queryCatalogInBundleRequest.getPageIndex () && null != queryCatalogInBundleRequest.getPageSize ())
		{
			params.put ("start",
					(queryCatalogInBundleRequest.getPageIndex () - 1) * queryCatalogInBundleRequest.getPageSize ());
			params.put ("size", queryCatalogInBundleRequest.getPageSize ());
		}
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());

		List<BundleAppOrCatalogRelation> bundleAppOrCatalogRelations = bundleAppOrCatalogRelationMapper
				.queryCatalogInBundle (params);

		if (! CollectionUtils.isEmpty (bundleAppOrCatalogRelations))
		{
			List<BundleAppOrCatalogRelationVo> bundleAppOrCatalogRelationVos = Lists.newArrayList ();
			bundleAppOrCatalogRelations.forEach (bundleAppOrCatalogRelation -> {
				BundleAppOrCatalogRelationVo bundleAppOrCatalogRelationVo = new BundleAppOrCatalogRelationVo ();
				BeanUtils.copyProperties (bundleAppOrCatalogRelation, bundleAppOrCatalogRelationVo);
				bundleAppOrCatalogRelationVos.add (bundleAppOrCatalogRelationVo);
			});
			result.setData (bundleAppOrCatalogRelationVos);
			result.setTotalCount (bundleAppOrCatalogRelationMapper.countCatalogInBundle (params));
		}
		result.success ();
		return result;
	}

	/**
	 * 查询不在套餐中的栏目
	 *
	 * @param queryCatalogNotInBundleRequest
	 * @return
	 */
	@Override
	public Result<List<BundleAppOrCatalogRelationVo>> queryCatalogNotInBundle (
			@RequestBody QueryCatalogNotInBundleRequest queryCatalogNotInBundleRequest)
	{
		if (null == queryCatalogNotInBundleRequest)
		{
			return new Result ().failure ("illega params");
		}

		i ("BUNDLEAPPORCATALOGRELATION", "queryCatalogNotInBundle", LOG_TYPE_REQUEST, queryCatalogNotInBundleRequest);

		Result<List<BundleAppOrCatalogRelationVo>> result = new Result<> ();
		Map<String, Object> params = new HashMap<> ();
		if (! StringUtils.isEmpty (queryCatalogNotInBundleRequest.getPackageId ()))
		{
			params.put ("packageId", queryCatalogNotInBundleRequest.getPackageId ());
		}
		if (null != queryCatalogNotInBundleRequest.getPageIndex () && null != queryCatalogNotInBundleRequest
				.getPageSize ())
		{
			params.put ("start", (queryCatalogNotInBundleRequest.getPageIndex () - 1) * queryCatalogNotInBundleRequest
					.getPageSize ());
			params.put ("size", queryCatalogNotInBundleRequest.getPageSize ());
		}
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());

		List<BundleAppOrCatalogRelation> bundleAppOrCatalogRelations = bundleAppOrCatalogRelationMapper
				.queryCatalogNotInBundle (params);

		if (! CollectionUtils.isEmpty (bundleAppOrCatalogRelations))
		{
			List<BundleAppOrCatalogRelationVo> bundleAppOrCatalogRelationVos = Lists.newArrayList ();
			bundleAppOrCatalogRelations.forEach (bundleAppOrCatalogRelation -> {
				BundleAppOrCatalogRelationVo bundleAppOrCatalogRelationVo = new BundleAppOrCatalogRelationVo ();
				BeanUtils.copyProperties (bundleAppOrCatalogRelation, bundleAppOrCatalogRelationVo);
				bundleAppOrCatalogRelationVos.add (bundleAppOrCatalogRelationVo);
			});
			result.setData (bundleAppOrCatalogRelationVos);
			result.setTotalCount (bundleAppOrCatalogRelationMapper.countCatalogNotInBundle (params));
		}
		result.success ();
		return result;
	}

	/**
	 * 查询栏目或者应用是否在套餐中
	 *
	 * @param queryAppOrCatalogIsInBundleRequest
	 * @return
	 */
	@Override
	public Result queryAppOrCatalogIsInBundle (
			@RequestBody QueryAppOrCatalogIsInBundleRequest queryAppOrCatalogIsInBundleRequest)
	{
		if (null == queryAppOrCatalogIsInBundleRequest)
		{
			return new Result ().failure ("illega params");
		}

		i ("BUNDLEAPPORCATALOGRELATION", "queryAppOrCatalogIsInBundle", LOG_TYPE_REQUEST,
				queryAppOrCatalogIsInBundleRequest);

		Map<String, Object> params = new HashMap<> ();
		if (! StringUtils.isEmpty (queryAppOrCatalogIsInBundleRequest.getPackageId ()))
		{
			params.put ("packageId", queryAppOrCatalogIsInBundleRequest.getPackageId ());
		}
		if (! StringUtils.isEmpty (queryAppOrCatalogIsInBundleRequest.getCatalogId ()))
		{
			params.put ("catalogId", queryAppOrCatalogIsInBundleRequest.getCatalogId ());
		}
		if (! StringUtils.isEmpty (queryAppOrCatalogIsInBundleRequest.getAppId ()))
		{
			params.put ("appId", queryAppOrCatalogIsInBundleRequest.getAppId ());
		}

		int count = bundleAppOrCatalogRelationMapper.queryAppOrCatalogIsInBundle (params);

		if (count <= 0)
		{
			return new Result ().failure ("the catalog or app not in bundle");
		}
		else
		{
			return new Result ().success ();
		}
	}
}
