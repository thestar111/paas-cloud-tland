/**
 * 文 件 名:  CatalogrelationFallbackFactory
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.service.catalogrelation;

import com.quanteng.tland.cms.pojo.catalog.domain.CatalogVo;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.*;
import com.quanteng.tland.cms.pojo.catalogrelation.request.*;
import com.quanteng.tland.common.domain.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <栏目应用关系服务降级实现>
 *
 * @author LJun
 * @version 2018/5/17
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class CatalogRelationFallbackFactory implements FallbackFactory<CatalogRelationService>
{
	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (CatalogRelationFallbackFactory.class);

	@Override
	public CatalogRelationService create (Throwable throwable)
	{
		LOGGER.error (String.format ("Catalogrelation Service Not Available : %s", throwable.getMessage ()));
		return new CatalogRelationService ()
		{

			/**
			 *添加栏目应用关系
			 * @param createCatalogRelationRequest
			 * @return
			 */
			@Override
			public Result<String> createCatalogRelation (CreateCatalogRelationRequest createCatalogRelationRequest)
			{
				return new Result ().failure ("Cms Service not Available");
			}

			/**
			 * 根据营销栏目Id和appId删除对应关系
			 * @param columnId
			 * @param targetId
			 * @return
			 */
			@Override
			public Result<String> deleteCatalogRelationById (String columnId, String targetId)
			{
				return new Result ().failure ("Cms Service not Available");
			}

			/**
			 * 查询栏目应用关联关系
			 * @param qryCatalogAppRelationRequest
			 * @return
			 */
			@Override
			public Result<CatalogMessage<CatalogAppRelationVo>> qryCatalogAppRelation (
					QryCatalogAppRelationRequest qryCatalogAppRelationRequest)
			{
				return new Result ().failure ("Cms Service not Available");
			}

			/**
			 * 查询应用栏目关联关系 供APP客户端使用
			 *
			 * @param qryCatalogAppRelationRequest
			 * @return
			 */
			@Override
			public Result<CatalogMessage<AppMessage>> qryAppByAppCatalogId (
					QryCatalogAppRelationRequest qryCatalogAppRelationRequest)
			{
				return new Result ().failure ("Cms Service not Available");
			}

			/**
			 * 查询不在栏目应用关联关系内的app
			 * @param qryAppNotInCatalogRequest
			 * @return
			 */
			@Override
			public Result<List<AppMessage>> qryAppNotInCatalog (QryAppNotInCatalogRequest qryAppNotInCatalogRequest)
			{
				return new Result ().failure ("Cms Service not Available");
			}

			/**
			 * 查询不在栏目内的广告信息
			 *
			 * @param queryCatalogRelationRequest
			 * @return
			 */
			@Override
			public Result<List<AdsMessage>> qryAdsNotInCatalog (QueryCatalogRelationRequest queryCatalogRelationRequest)
			{
				return new Result ().failure ("Cms Service not Available");
			}

			/**
			 * 查询不在栏目内的栏目信息
			 *
			 * @param queryCatalogRelationRequest
			 * @return
			 */
			@Override
			public Result<List<CatalogVo>> qryCatalogNotInCatalog (
					QueryCatalogRelationRequest queryCatalogRelationRequest)
			{
				return new Result ().failure ("Cms Service not Available");
			}

			/**
			 * 更新应该排序位置
			 * @param batchModifyRanksRequest
			 * @return
			 */
			@Override
			public Result<String> batchUpdatePriority (BatchModifyRanksRequest batchModifyRanksRequest)
			{
				return new Result ().failure ("Cms Service not Available");
			}

			/**
			 * 置顶当前栏目关系位置
			 * @param modifyRelationToTopRequest
			 * @return
			 */
			@Override
			public Result<String> modifyCatalogRelationToTop (ModifyRelationToTopRequest modifyRelationToTopRequest)
			{
				return new Result ().failure ("Cms Service not Available");
			}

			/**
			 * 查询栏目目标对象关系
			 *
			 * @param queryCatalogRelationRequest
			 * @return
			 */
			@Override
			public Result<TargetRelationVo> queryCatalogTargetRelation (
					QueryCatalogRelationRequest queryCatalogRelationRequest)
			{
				return new Result ().failure ("Cms Service not Available");
			}

			/**
			 * 查询客户端应用首页营销信息
			 * @return
			 */
			@Override
			public Result<List<CatalogMessage>> queryPromotionIndex ()
			{
				return new Result ().failure ("Cms Service not Available");
			}

			/**
			 * 查询营销类广告信息
			 * @param type
			 * @return
			 */
			@Override
			public Result<List<AdsMessage>> queryPromotionAdsByType (Integer type)
			{
				return new Result ().failure ("Cms Service not Available");
			}

			/**
			 *查询营销HOT标签信息
			 * @return
			 */
			@Override
			public Result<CatalogMessage<CatalogMessage>> queryPromotionTagByType ()
			{
				return new Result ().failure ("Cms Service not Available");
			}
		};
	}
}
