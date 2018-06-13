/**
 * 文 件 名:  ColumnAppRelaResource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/8/10
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.catalogrelation;

import com.quanteng.tland.cms.pojo.catalog.domain.CatalogVo;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.*;
import com.quanteng.tland.cms.pojo.catalogrelation.request.*;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <栏目应用关系资源接口>
 *
 * @author zhengbinggui
 * @version 2017/8/10
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/cms/catalogRelation")
public interface CatalogRelationResource
{
	/**
	 * 添加栏目应用关系
	 *
	 * @param createCatalogRelationRequest
	 * @return
	 */
	@RequestMapping (value = "/addCatalogRelation", method = RequestMethod.POST)
	Result<String> createCatalogRelation (@RequestBody CreateCatalogRelationRequest createCatalogRelationRequest);

	/**
	 * 根据营销栏目Id和目标Id删除对应关系
	 *
	 * @param catalogId
	 * @param targetId
	 * @return
	 */
	@RequestMapping (value = "/delete/{catalogId}/{target}", method = RequestMethod.DELETE)
	Result<String> deleteCatalogRelationById (@PathVariable ("catalogId") String catalogId,
			@PathVariable ("target") String targetId);

	/**
	 * 查询应用栏目关联关系 供平台使用
	 *
	 * @param qryCatalogAppRelationRequest
	 * @return
	 */
	@RequestMapping (value = "/qryCatalogAppRelation", method = RequestMethod.POST)
	Result<CatalogMessage<CatalogAppRelationVo>> qryCatalogAppRelation (
			@RequestBody QryCatalogAppRelationRequest qryCatalogAppRelationRequest);

	/**
	 * 查询应用栏目关联关系 供APP客户端使用
	 *
	 * @param qryCatalogAppRelationRequest
	 * @return
	 */
	@RequestMapping (value = "/qryAppByAppCatalogRelationId", method = RequestMethod.POST)
	Result<CatalogMessage<AppMessage>> qryAppByAppCatalogId (
			@RequestBody QryCatalogAppRelationRequest qryCatalogAppRelationRequest);

	/**
	 * 查询不在栏目应用关联关系内的app
	 *
	 * @param qryAppNotInCatalogRequest
	 * @return
	 */
	@RequestMapping (value = "/qryAppNotInCatalog", method = RequestMethod.POST)
	Result<List<AppMessage>> qryAppNotInCatalog (@RequestBody QryAppNotInCatalogRequest qryAppNotInCatalogRequest);

	/**
	 * 查询不在栏目内的广告信息
	 *
	 * @param queryCatalogRelationRequest
	 * @return
	 */
	@RequestMapping (value = "/qryAdsNotInCatalog", method = RequestMethod.POST)
	Result<List<AdsMessage>> qryAdsNotInCatalog (@RequestBody QueryCatalogRelationRequest queryCatalogRelationRequest);

	/**
	 * 查询不在栏目内的栏目信息
	 *
	 * @param queryCatalogRelationRequest
	 * @return
	 */
	@RequestMapping (value = "/qryCatalogNotInCatalog", method = RequestMethod.POST)
	Result<List<CatalogVo>> qryCatalogNotInCatalog (
			@RequestBody QueryCatalogRelationRequest queryCatalogRelationRequest);

	/**
	 * 更新应该排序位置
	 *
	 * @param batchModifyRanksRequest
	 * @return
	 */
	@RequestMapping (value = "/batchUpdateRanks", method = RequestMethod.PUT)
	Result<String> batchUpdatePriority (@RequestBody BatchModifyRanksRequest batchModifyRanksRequest);

	/**
	 * 置顶当前栏目关系位置
	 *
	 * @param modifyRelationToTopRequest
	 * @return
	 */
	@RequestMapping (value = "/getCatalogAppToMove", method = RequestMethod.PUT)
	Result<String> modifyCatalogRelationToTop (@RequestBody ModifyRelationToTopRequest modifyRelationToTopRequest);

	/**
	 * 查询栏目目标对象关系
	 *
	 * @param queryCatalogRelationRequest
	 * @return
	 */
	@RequestMapping (value = "/queryCatalogTatgetRelation", method = RequestMethod.POST)
	Result<TargetRelationVo> queryCatalogTargetRelation (
			@RequestBody QueryCatalogRelationRequest queryCatalogRelationRequest);

	/**
	 * 查询客户端应用首页营销信息
	 *
	 * @return
	 */
	@RequestMapping (value = "/queryPromotionIndex", method = RequestMethod.GET)
	Result<List<CatalogMessage>> queryPromotionIndex ();

	/**
	 * 查询营销类广告信息
	 *
	 * @param type
	 * @return
	 */
	@RequestMapping (value = "/queryPromotionAds/{type}", method = RequestMethod.GET)
	Result<List<AdsMessage>> queryPromotionAdsByType (@PathVariable ("type") Integer type);

	/**
	 * 查询营销HOT标签信息
	 *
	 * @return
	 */
	@RequestMapping (value = "/query/hotTags", method = RequestMethod.GET)
	Result<CatalogMessage<CatalogMessage>> queryPromotionTagByType ();
}