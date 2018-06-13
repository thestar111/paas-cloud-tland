/**
 * 文 件 名:  PackageAppRelaMapper
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/10/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.mapper;

import com.quanteng.tland.cms.database.entity.BundleAppOrCatalogRelation;

import java.util.List;
import java.util.Map;

/**
 * <套餐应用关系管理MAPPER>
 *
 * @author zhengbinggui
 * @version 2017/10/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface BundleAppOrCatalogRelationMapper
{
	/**
	 * 批量新增套餐应用或栏目关系
	 *
	 * @param bundleAppOrCatalogRelations
	 */
	int batchAdd (List<BundleAppOrCatalogRelation> bundleAppOrCatalogRelations);

	/**
	 * 查询栏目或者应用是否在套餐中
	 *
	 * @param params
	 * @return
	 */
	int queryAppOrCatalogIsInBundle (Map<String, Object> params);

	/**
	 * 分页查询套餐中的应用
	 *
	 * @param params
	 * @return
	 */
	List<BundleAppOrCatalogRelation> queryAppInBundle (Map<String, Object> params);

	/**
	 * 查询套餐中的应用总数
	 *
	 * @param params
	 * @return
	 */
	int countAppInBundle (Map<String, Object> params);

	/**
	 * 查询套餐中的栏目
	 *
	 * @param params
	 * @return
	 */
	List<BundleAppOrCatalogRelation> queryCatalogInBundle (Map<String, Object> params);

	/**
	 * 查询套餐中的栏目总数
	 *
	 * @param params
	 * @return
	 */
	int countCatalogInBundle (Map<String, Object> params);

	/**
	 * 批量删除套餐应用或栏目关系
	 *
	 * @param ids
	 */
	int batchDelete (List<String> ids);

	/**
	 * 分页查询不在套餐中的应用
	 *
	 * @param params
	 * @return
	 */
	List<BundleAppOrCatalogRelation> queryAppNotInBundle (Map<String, Object> params);

	/**
	 * 查询不在套餐中的应用总数
	 *
	 * @param params
	 * @return
	 */
	int countAppNotInBundle (Map<String, Object> params);

	/**
	 * 查询不在套餐中的栏目
	 *
	 * @param params
	 * @return
	 */
	List<BundleAppOrCatalogRelation> queryCatalogNotInBundle (Map<String, Object> params);

	/**
	 * 查询不在套餐中的栏目总数
	 *
	 * @param params
	 * @return
	 */
	int countCatalogNotInBundle (Map<String, Object> params);
}