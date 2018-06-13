/**
 * 文 件 名:  BundleAppOrCatalogRelationResource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/10/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.bundleapporcatalogrelation;

import com.quanteng.tland.cms.pojo.bundleapporcatalogrelation.domain.BundleAppOrCatalogRelationVo;
import com.quanteng.tland.cms.pojo.bundleapporcatalogrelation.request.*;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <套餐应用配置资源接口>
 *
 * @author zhengbinggui
 * @version 2017/10/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/cms/bundleAppOrCatalogRelation")
public interface BundleAppOrCatalogRelationResource
{

	/**
	 * 批量新增套餐应用或栏目关系
	 *
	 * @param batchAddBundleAppOrCatalogRelationRequest
	 * @return
	 */
	@RequestMapping (value = "/batchAdd", method = RequestMethod.POST)
	Result batchAdd (@RequestBody BatchAddBundleAppOrCatalogRelationRequest batchAddBundleAppOrCatalogRelationRequest);

	/**
	 * 批量删除套餐应用或栏目关系
	 *
	 * @param batchDeleteBundleAppOrCatalogRelationByIdRequest
	 * @return
	 */
	@RequestMapping (value = "/batchDelete", method = RequestMethod.DELETE)
	Result batchDelete (
			@RequestBody BatchDeleteBundleAppOrCatalogRelationByIdRequest batchDeleteBundleAppOrCatalogRelationByIdRequest);

	/**
	 * 查询套餐中的应用
	 *
	 * @param queryAppInBundleRequest
	 * @return
	 */
	@RequestMapping (value = "/queryAppInBundle", method = RequestMethod.POST)
	Result<List<BundleAppOrCatalogRelationVo>> queryAppInBundle (
			@RequestBody QueryAppInBundleRequest queryAppInBundleRequest);

	/**
	 * 查询不在套餐中的应用
	 *
	 * @param queryAppNotInBundleRequest
	 * @return
	 */
	@RequestMapping (value = "/queryAppNotInBundle", method = RequestMethod.POST)
	Result<List<BundleAppOrCatalogRelationVo>> queryAppNotInBundle (
			@RequestBody QueryAppNotInBundleRequest queryAppNotInBundleRequest);

	/**
	 * 查询套餐中的栏目
	 *
	 * @param queryCatalogInBundleRequest
	 * @return
	 */
	@RequestMapping (value = "/queryCatalogInBundle", method = RequestMethod.POST)
	Result<List<BundleAppOrCatalogRelationVo>> queryCatalogInBundle (
			@RequestBody QueryCatalogInBundleRequest queryCatalogInBundleRequest);

	/**
	 * 查询不在套餐中的栏目
	 *
	 * @param queryCatalogNotInBundleRequest
	 * @return
	 */
	@RequestMapping (value = "/queryCatalogNotInBundle", method = RequestMethod.POST)
	Result<List<BundleAppOrCatalogRelationVo>> queryCatalogNotInBundle (
			@RequestBody QueryCatalogNotInBundleRequest queryCatalogNotInBundleRequest);

	/**
	 * 查询栏目或者应用是否在套餐中
	 *
	 * @param queryAppOrCatalogIsInBundleRequest
	 * @return
	 */
	@RequestMapping (value = "/queryAppOrCatalogIsInBundle", method = RequestMethod.POST)
	Result queryAppOrCatalogIsInBundle (@RequestBody QueryAppOrCatalogIsInBundleRequest queryAppOrCatalogIsInBundleRequest);
}