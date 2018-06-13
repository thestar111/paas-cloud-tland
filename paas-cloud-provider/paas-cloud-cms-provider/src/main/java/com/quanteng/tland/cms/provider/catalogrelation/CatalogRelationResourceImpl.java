/**
 * 文 件 名:  CatalogRelationResourceImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/10 0010
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.catalogrelation;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.quanten.core.utils.GenerateSequenceID;
import com.quanteng.tland.cms.api.catalogrelation.CatalogRelationResource;
import com.quanteng.tland.cms.database.entity.*;
import com.quanteng.tland.cms.database.mapper.CatalogRelationMapper;
import com.quanteng.tland.cms.pojo.catalog.domain.CatalogVo;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.*;
import com.quanteng.tland.cms.pojo.catalogrelation.request.*;
import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.common.thread.Language;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.quanteng.tland.common.cons.Constants.Cons.*;
import static com.quanteng.tland.common.log.TlandLogger.*;

/**
 * <栏目关系资源接口实现>
 *
 * @author zping
 * @version 2018/5/10 0010
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class CatalogRelationResourceImpl implements CatalogRelationResource
{

	@Autowired
	private CatalogRelationMapper catalogRelationMapper;

	/**
	 * 栏目关系广告类型
	 */
	private static final Integer INDEX_AD_RELATION_TYPE = 1;
	/**
	 * 分类页广告类型
	 */
	private static final Integer CATALOG_AD_RELATION_TYPE = 2;
	/**
	 * 首页广告类型
	 */
	private static final Integer INDEX_APP_RELATION_TYPE = 3;
	/**
	 * 应用类型
	 */
	private static final Integer APP_RELATION_TYPE = 5;
	/**
	 * 栏目类型
	 */
	private static final Integer CATALOG_RELATION_TYPE = 4;
	/**
	 * 轮播广告类型
	 */
	private static final Integer BANNER_ADS_TYPE = 6;

	/**
	 * 添加栏目应用关系
	 *
	 * @param createCatalogRelationRequest
	 * @return
	 */
	@Override
	public Result<String> createCatalogRelation (@RequestBody CreateCatalogRelationRequest createCatalogRelationRequest)
	{
		if (null == createCatalogRelationRequest || CollectionUtils
				.isEmpty (createCatalogRelationRequest.getCatalogRelations ()))
		{
			return new Result<String> ().failure ("illega params");
		}

		i ("CATALOGRELATION", "createCatalogRelation", LOG_TYPE_REQUEST, createCatalogRelationRequest);
		List<CatalogRelationVo> catalogRelationVos = createCatalogRelationRequest.getCatalogRelations ();
		List<CatalogRelation> catalogRelations = Lists.newArrayList ();
		CatalogRelation catalogRelation = null;
		int maxOrder = catalogRelationMapper
				.queryMaxOrderByCatalogId (createCatalogRelationRequest.getCatalogRelations ().get (0).getCatalogId ());
		for (CatalogRelationVo catalogRelationVo : catalogRelationVos)
		{
			//位置增1
			maxOrder = maxOrder + 1;
			catalogRelation = new CatalogRelation ();
			BeanUtils.copyProperties (catalogRelationVo, catalogRelation);
			catalogRelation.setId (GenerateSequenceID.getSeqID ());
			catalogRelation.setOrderNum (maxOrder);
			catalogRelations.add (catalogRelation);
		}
		int flag = catalogRelationMapper.addCatalogRelation (catalogRelations);
		i ("CATALOGRELATION", "createCatalogRelation", LOG_TYPE_RESPONSE, flag);
		if (0 < flag)
		{
			return new Result<String> ().success ();
		}
		else
		{
			return new Result<String> ().failure ("add catalog relation failed.");
		}
	}

	/**
	 * 根据营销栏目Id和targetId删除对应关系
	 *
	 * @param catalogId
	 * @param targetId
	 * @return
	 */
	@Override
	public Result<String> deleteCatalogRelationById (@PathVariable ("catalogId") String catalogId,
			@PathVariable ("target") String targetId)
	{
		if (StringUtils.isEmpty (catalogId))
		{
			return new Result<> ().failure ("catalogId is null");
		}

		if (StringUtils.isEmpty (targetId))
		{
			return new Result<> ().failure ("appId is null");
		}

		i ("CATALOGRELATION", "deleteCatalogRelationById", LOG_TYPE_REQUEST, catalogId);
		int flag = catalogRelationMapper.deleteCatalogRelaById (catalogId, targetId);
		i ("CATALOGRELATION", "deleteCatalogRelationById", LOG_TYPE_RESPONSE, flag);

		if (0 < flag)
		{
			return new Result<String> ().success ();
		}
		else
		{
			return new Result<String> ().failure ("delete catalog relation failed.");
		}
	}

	/**
	 * 查询栏目应用关联关系 market使用
	 *
	 * @param qryCatalogAppRelationRequest
	 * @return
	 */
	@Override
	public Result<CatalogMessage<CatalogAppRelationVo>> qryCatalogAppRelation (
			@RequestBody QryCatalogAppRelationRequest qryCatalogAppRelationRequest)
	{
		if (null == qryCatalogAppRelationRequest)
		{
			return new Result ().failure ("qryCatalogAppRelationRequest is null");
		}

		if (null == qryCatalogAppRelationRequest.getType ())
		{
			return new Result ().failure ("type is null");
		}

		Result<CatalogMessage<CatalogAppRelationVo>> result = new Result<> ();
		Map<String, Object> params = Maps.newHashMap ();
		if (StringUtils.isEmpty (qryCatalogAppRelationRequest.getCatalogId ()))
		{
			return new Result<> ().failure ("catalog is empty.");
		}

		if (! StringUtils.isEmpty (qryCatalogAppRelationRequest.getAppName ()))
		{
			params.put ("name", qryCatalogAppRelationRequest.getAppName ());
		}

		params.put ("catalogId", qryCatalogAppRelationRequest.getCatalogId ());
		params.put ("type", qryCatalogAppRelationRequest.getType ());
		params.put (DATA_PAGE_START,
				(qryCatalogAppRelationRequest.getPageIndex () - 1) * qryCatalogAppRelationRequest.getPageSize ());
		params.put (DATA_PAGE_SIZE, qryCatalogAppRelationRequest.getPageSize () + 1);
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());

		i ("CATALOGRELATION", "qryCatalogAppRelation", LOG_TYPE_REQUEST, qryCatalogAppRelationRequest);
		List<CatalogAppRela> catalogAppRelas = catalogRelationMapper.queryConfigAppByCatalogId (params);
		i ("CATALOGRELATION", "qryCatalogAppRelation", LOG_TYPE_RESPONSE, catalogAppRelas);

		CatalogMessage<CatalogAppRelationVo> catalogAppRelation = null;
		if (! CollectionUtils.isEmpty (catalogAppRelas))
		{
			catalogAppRelation = new CatalogMessage<CatalogAppRelationVo> ();
			List<CatalogAppRelationVo> appMessages = Lists.newArrayList ();
			CatalogAppRelationVo appMessage = null;
			for (CatalogAppRela catalogAppRela : catalogAppRelas)
			{
				appMessage = new CatalogAppRelationVo ();
				BeanUtils.copyProperties (catalogAppRela, appMessage);
				appMessages.add (appMessage);
			}
			BeanUtils.copyProperties (catalogAppRelas.get (0), catalogAppRelation);
			catalogAppRelation.setTarget (appMessages);
			result.setTotalCount (catalogRelationMapper.queryConfigAppCountByCatalogId (params));
		}
		return result.success (catalogAppRelation);
	}

	/**
	 * 查询应用栏目关联关系 供APP客户端使用
	 *
	 * @param qryCatalogAppRelationRequest
	 * @return
	 */
	@Override
	public Result<CatalogMessage<AppMessage>> qryAppByAppCatalogId (
			@RequestBody QryCatalogAppRelationRequest qryCatalogAppRelationRequest)
	{
		if (null == qryCatalogAppRelationRequest || StringUtils.isEmpty (qryCatalogAppRelationRequest.getCatalogId ()))
		{
			return new Result ().failure ("illega parameter is null");
		}

		Result<CatalogMessage<AppMessage>> result = new Result<> ();
		Map<String, Object> params = Maps.newHashMap ();
		params.put ("catalogId", qryCatalogAppRelationRequest.getCatalogId ());
		params.put (DATA_PAGE_START,
				(qryCatalogAppRelationRequest.getPageIndex () - 1) * qryCatalogAppRelationRequest.getPageSize ());
		params.put (DATA_PAGE_SIZE, qryCatalogAppRelationRequest.getPageSize () + 1);
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());

		i ("CATALOGRELATION", "qryCatalogAppRelation", LOG_TYPE_REQUEST, qryCatalogAppRelationRequest);
		List<CatalogAppRela> catalogAppRelas = catalogRelationMapper.queryAppByAppCatalogId (params);
		i ("CATALOGRELATION", "qryCatalogAppRelation", LOG_TYPE_RESPONSE, catalogAppRelas);

		CatalogMessage<AppMessage> catalogAppRelation = null;
		if (! CollectionUtils.isEmpty (catalogAppRelas))
		{
			catalogAppRelation = new CatalogMessage<> ();
			List<AppMessage> appMessages = Lists.newArrayList ();
			AppMessage appMessage = null;
			for (CatalogAppRela catalogAppRela : catalogAppRelas)
			{
				appMessage = new AppMessage ();
				BeanUtils.copyProperties (catalogAppRela, appMessage);
				appMessages.add (appMessage);
			}
			catalogAppRelation.setTarget (appMessages);
		}
		return result.success (catalogAppRelation);
	}

	/**
	 * 查询不在栏目应用关联关系内的app应用信息
	 *
	 * @param qryAppNotInCatalogRequest
	 * @return
	 */
	@Override
	public Result<List<AppMessage>> qryAppNotInCatalog (
			@RequestBody QryAppNotInCatalogRequest qryAppNotInCatalogRequest)
	{
		if (null == qryAppNotInCatalogRequest)
		{
			return new Result ().failure ("qryAppNotInCatalogRequest is null");
		}
		if (null == qryAppNotInCatalogRequest.getType ())
		{
			return new Result ().failure ("type is null");
		}

		Result<List<AppMessage>> result = new Result<> ();
		Map<String, Object> params = Maps.newHashMap ();
		if (StringUtils.isEmpty (qryAppNotInCatalogRequest.getCatalogId ()))
		{
			return new Result<> ().failure ("catalog is empty.");
		}

		if (! StringUtils.isEmpty (qryAppNotInCatalogRequest.getAppName ()))
		{
			params.put ("name", qryAppNotInCatalogRequest.getAppName ());
		}

		params.put ("catalogId", qryAppNotInCatalogRequest.getCatalogId ());
		params.put ("type", qryAppNotInCatalogRequest.getType ());
		params.put (DATA_PAGE_START,
				(qryAppNotInCatalogRequest.getPageIndex () - 1) * qryAppNotInCatalogRequest.getPageSize ());
		params.put (DATA_PAGE_SIZE, qryAppNotInCatalogRequest.getPageSize ());
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());

		i ("CATALOGRELATION", "qryAppNotInCatalog", LOG_TYPE_REQUEST, qryAppNotInCatalogRequest);
		List<CatalogAppRela> catalogAppRelas = catalogRelationMapper.queryAppNotInCatalogId (params);
		i ("CATALOGRELATION", "qryAppNotInCatalog", LOG_TYPE_RESPONSE, catalogAppRelas);
		List<AppMessage> appMessages = null;
		if (! CollectionUtils.isEmpty (catalogAppRelas))
		{
			appMessages = Lists.newArrayList ();
			AppMessage appMessage = null;
			for (CatalogAppRela catalogAppRela : catalogAppRelas)
			{
				appMessage = new AppMessage ();
				BeanUtils.copyProperties (catalogAppRela, appMessage);
				appMessages.add (appMessage);
			}
			result.setTotalCount (catalogRelationMapper.queryAppCountNotInCatalogId (params));
		}
		result.setData (appMessages);
		return result;
	}

	/**
	 * 更新应该排序位置
	 *
	 * @param batchModifyRanksRequest
	 * @return
	 */
	@Override
	public Result<String> batchUpdatePriority (@RequestBody BatchModifyRanksRequest batchModifyRanksRequest)
	{
		if (null == batchModifyRanksRequest || CollectionUtils.isEmpty (batchModifyRanksRequest.getCatalogRelations ()))
		{
			return new Result<> ().failure ("illega params.");
		}

		List<CatalogRelationVo> catalogRelationVos = batchModifyRanksRequest.getCatalogRelations ();
		List<CatalogRelation> catalogRelations = Lists.newArrayList ();
		CatalogRelation catalogRelation = null;
		for (CatalogRelationVo catalogRelationVo : catalogRelationVos)
		{
			catalogRelation = new CatalogRelation ();
			BeanUtils.copyProperties (catalogRelationVo, catalogRelation);
			catalogRelations.add (catalogRelation);
		}

		i ("CATALOGRELATION", "batchUpdatePriority", LOG_TYPE_REQUEST, batchModifyRanksRequest);
		int flag = catalogRelationMapper.modifyCatalogRelationRank (catalogRelations);
		i ("CATALOGRELATION", "batchUpdatePriority", LOG_TYPE_RESPONSE, flag);

		if (0 < flag)
		{
			return new Result<String> ().success ();
		}
		else
		{
			return new Result<String> ().failure ("batch modify catalog relation failed.");
		}
	}

	/**
	 * 置顶栏目应用位置
	 *
	 * @param modifyRelationToTopRequest
	 * @return
	 */
	@Override
	public Result modifyCatalogRelationToTop (@RequestBody ModifyRelationToTopRequest modifyRelationToTopRequest)
	{
		if (StringUtils.isEmpty (modifyRelationToTopRequest.getId ()))
		{
			return new Result ().failure ("illega params");
		}

		if (StringUtils.isEmpty (modifyRelationToTopRequest.getCatalogId ()))
		{
			return new Result ().failure ("illega params");
		}
		i ("CATALOGRELATION", "modifyCatalogRelationToTop", LOG_TYPE_REQUEST, modifyRelationToTopRequest);
		Integer orderNum = catalogRelationMapper.getOrderNumById (modifyRelationToTopRequest.getId ());
		i ("CATALOGRELATION", "modifyCatalogRelationToTop", "CURRENT_POSITION", orderNum);
		if (orderNum < 0)
		{
			return new Result ().failure ("modify failed.");
		}

		List<CatalogRelation> catalogRelations = catalogRelationMapper
				.queryBeforeTargetRelation (modifyRelationToTopRequest.getCatalogId (), orderNum - 1);
		i ("CATALOGRELATION", "modifyCatalogRelationToTop", "BEFORE_POSITION", catalogRelations);
		if (! CollectionUtils.isEmpty (catalogRelations))
		{
			for (CatalogRelation catalogRelation : catalogRelations)
			{
				catalogRelation.setOrderNum (catalogRelation.getOrderNum () + 1);
			}
			CatalogRelation currentCatalogRelation = new CatalogRelation ();
			currentCatalogRelation.setOrderNum (1);
			currentCatalogRelation.setId (modifyRelationToTopRequest.getId ());
			catalogRelations.add (currentCatalogRelation);
			i ("CATALOGRELATION", "modifyCatalogRelationToTop", "BATCH_MODIFY", catalogRelations);
			int flag = catalogRelationMapper.modifyCatalogRelationRank (catalogRelations);
			i ("CATALOGRELATION", "modifyCatalogRelationToTop", LOG_TYPE_RESPONSE, catalogRelations);
			if (0 < flag)
			{
				return new Result<String> ().success ();
			}
			else
			{
				return new Result<String> ().failure ("batch modify catalog relation failed.");
			}
		}
		else
		{
			return new Result ().failure ("top failed.");
		}
	}

	/**
	 * 查询栏目目标对象关系
	 *
	 * @param queryCatalogRelationRequest
	 * @return
	 */
	@Override
	public Result<TargetRelationVo> queryCatalogTargetRelation (
			@RequestBody QueryCatalogRelationRequest queryCatalogRelationRequest)
	{
		if (StringUtils.isEmpty (queryCatalogRelationRequest.getCatalogId ()))
		{
			return new Result<> ().failure ("catalogId is null");
		}

		i ("CATALOGRELATION", "queryCatalogTargetRelation", LOG_TYPE_REQUEST, queryCatalogRelationRequest);
		//查询栏目关系类型
		Integer type = catalogRelationMapper.queryTypeByCatalogId (queryCatalogRelationRequest.getCatalogId ());
		i ("CATALOGRELATION", "queryCatalogTargetRelation", "CATALOG_TYPE", type);

		if (null == type || 0 > type)
		{
			return new Result<> ().failure ("catalog relation not exist.");
		}

		Result<TargetRelationVo> result = new Result<> ();
		TargetRelationVo targetRelationVo = new TargetRelationVo ();
		Map<String, Object> params = Maps.newHashMap ();
		params.put (DATA_PAGE_START,
				(queryCatalogRelationRequest.getPageIndex () - 1) * queryCatalogRelationRequest.getPageSize ());
		params.put (DATA_PAGE_SIZE, queryCatalogRelationRequest.getPageSize ());
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());
		params.put ("catalogId", queryCatalogRelationRequest.getCatalogId ());

		// 广告
		if (INDEX_AD_RELATION_TYPE.equals (type) || CATALOG_AD_RELATION_TYPE.equals (type) || BANNER_ADS_TYPE
				.equals (type))
		{
			List<AdsCatalogVo> adsCatalogVos = null;
			List<CatalogAdsRela> catalogAdsRelas = catalogRelationMapper.queryAdsByCatalogId (params);
			if (! CollectionUtils.isEmpty (catalogAdsRelas))
			{
				adsCatalogVos = Lists.newArrayList ();
				AdsCatalogVo adsCatalogVo = null;
				for (CatalogAdsRela catalogAdsRela : catalogAdsRelas)
				{
					adsCatalogVo = new AdsCatalogVo ();
					BeanUtils.copyProperties (catalogAdsRela, adsCatalogVo);
					adsCatalogVos.add (adsCatalogVo);
				}
				targetRelationVo.setCatalogId (catalogAdsRelas.get (0).getCatalogId ());
				targetRelationVo.setType (catalogAdsRelas.get (0).getType ());
				targetRelationVo.setTarget (adsCatalogVos);
				result.setTotalCount (catalogRelationMapper.queryAdsCountByCatalogId (params));
			}
		}

		// 应用
		if (APP_RELATION_TYPE.equals (type) || INDEX_APP_RELATION_TYPE.equals (type))
		{
			List<CatalogAppRela> catalogAppRelas = catalogRelationMapper.queryConfigAppByCatalogId (params);
			List<AppCatalogVo> appCatalogVos = null;
			if (! CollectionUtils.isEmpty (catalogAppRelas))
			{
				appCatalogVos = Lists.newArrayList ();
				AppCatalogVo appCatalogVo = null;
				for (CatalogAppRela catalogAppRela : catalogAppRelas)
				{
					appCatalogVo = new AppCatalogVo ();
					BeanUtils.copyProperties (catalogAppRela, appCatalogVo);
					appCatalogVos.add (appCatalogVo);
				}
				targetRelationVo.setCatalogId (catalogAppRelas.get (0).getCatalogId ());
				targetRelationVo.setType (catalogAppRelas.get (0).getType ());
				targetRelationVo.setTarget (appCatalogVos);
				result.setTotalCount (catalogRelationMapper.queryConfigAppCountByCatalogId (params));
			}
		}

		//查询栏目信息
		if (CATALOG_RELATION_TYPE.equals (type))
		{
			List<ParentCatalog> catalogs = catalogRelationMapper.queryCatalogByCatalogId (params);
			if (! CollectionUtils.isEmpty (catalogs))
			{
				List<ParentCatalogRelation> parentCatalogRelations = Lists.newArrayList ();
				ParentCatalogRelation parentCatalogRelation = null;
				for (ParentCatalog parentCatalog : catalogs)
				{
					parentCatalogRelation = new ParentCatalogRelation ();
					parentCatalogRelation.setCatalogId (parentCatalog.getCatalogId ());
					parentCatalogRelation.setCatalogName (parentCatalog.getCatalogName ());
					parentCatalogRelation.setCatalogIcon (parentCatalog.getCatalogIcon ());
					parentCatalogRelation.setOrderNum (parentCatalog.getOrderNum ());
					parentCatalogRelation.setId (parentCatalog.getId ());
					parentCatalogRelations.add (parentCatalogRelation);
				}
				targetRelationVo.setCatalogId (catalogs.get (0).getParentCatalogId ());
				targetRelationVo.setType (catalogs.get (0).getType ());
				targetRelationVo.setTarget (parentCatalogRelations);
			}
		}
		i ("CATALOGRELATION", "queryCatalogTargetRelation", LOG_TYPE_RESPONSE, targetRelationVo);
		return result.success (targetRelationVo);
	}

	/**
	 * 查询不在栏目内的广告信息
	 *
	 * @param queryCatalogRelationRequest
	 * @return
	 */
	@Override
	public Result<List<AdsMessage>> qryAdsNotInCatalog (
			@RequestBody QueryCatalogRelationRequest queryCatalogRelationRequest)
	{
		if (StringUtils.isEmpty (queryCatalogRelationRequest.getCatalogId ()))
		{
			return new Result<> ().failure ("catalogId is null");
		}
		Result<List<AdsMessage>> result = new Result<> ();
		Map<String, Object> params = Maps.newHashMap ();
		params.put ("catalogId", queryCatalogRelationRequest.getCatalogId ());
		params.put (DATA_PAGE_START,
				(queryCatalogRelationRequest.getPageIndex () - 1) * queryCatalogRelationRequest.getPageSize ());
		params.put (DATA_PAGE_SIZE, queryCatalogRelationRequest.getPageSize ());
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());
		if (! StringUtils.isEmpty (queryCatalogRelationRequest.getName ()))
		{
			params.put ("name", queryCatalogRelationRequest.getName ());
		}
		if (null != queryCatalogRelationRequest.getType ())
		{
			params.put ("type", queryCatalogRelationRequest.getType ());
		}

		i ("CATALOGRELATION", "qryAdsNotInCatalog", LOG_TYPE_REQUEST, params);
		List<Ad> ads = catalogRelationMapper.queryAdsNotInCatalog (params);
		i ("CATALOGRELATION", "qryAdsNotInCatalog", LOG_TYPE_RESPONSE, ads);
		List<AdsMessage> adsMessages = null;
		if (! CollectionUtils.isEmpty (ads))
		{
			adsMessages = Lists.newArrayList ();
			AdsMessage adsMessage = null;
			for (Ad ad : ads)
			{
				adsMessage = new AdsMessage ();
				BeanUtils.copyProperties (ad, adsMessage);
				adsMessages.add (adsMessage);
			}
			result.setTotalCount (catalogRelationMapper.queryAdsCountNotInCatalog (params));
		}
		return result.success (adsMessages);
	}

	/**
	 * 查询不在栏目内的栏目信息
	 *
	 * @param queryCatalogRelationRequest
	 * @return
	 */
	@Override
	public Result<List<CatalogVo>> qryCatalogNotInCatalog (
			@RequestBody QueryCatalogRelationRequest queryCatalogRelationRequest)
	{
		if (StringUtils.isEmpty (queryCatalogRelationRequest.getCatalogId ()))
		{
			return new Result<> ().failure ("catalogId is null");
		}
		Result<List<CatalogVo>> result = new Result<> ();
		Map<String, Object> params = Maps.newHashMap ();
		params.put ("catalogId", queryCatalogRelationRequest.getCatalogId ());
		params.put (DATA_PAGE_START, queryCatalogRelationRequest.getPageIndex ());
		params.put (DATA_PAGE_SIZE, queryCatalogRelationRequest.getPageSize ());
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());
		if (! StringUtils.isEmpty (queryCatalogRelationRequest.getName ()))
		{
			params.put ("name", queryCatalogRelationRequest.getName ());
		}
		if (null != queryCatalogRelationRequest.getType ())
		{
			params.put ("type", queryCatalogRelationRequest.getType ());
		}

		i ("CATALOGRELATION", "qryAdsNotInCatalog", LOG_TYPE_REQUEST, params);
		List<Catalog> catalogs = catalogRelationMapper.queryCatalogNotInCatalog (params);
		i ("CATALOGRELATION", "qryAdsNotInCatalog", LOG_TYPE_RESPONSE, catalogs);
		List<CatalogVo> catalogVos = null;
		if (! CollectionUtils.isEmpty (catalogs))
		{
			catalogVos = Lists.newArrayList ();
			CatalogVo catalogVo = null;
			for (Catalog catalog : catalogs)
			{
				catalogVo = new CatalogVo ();
				BeanUtils.copyProperties (catalog, catalogVo);
				catalogVos.add (catalogVo);
			}
			result.setTotalCount (catalogRelationMapper.queryCatalogCountNotInCatalog (params));
		}
		return result.success (catalogVos);
	}

	/**
	 * 查询客户端应用首页营销信息
	 *
	 * @return
	 */
	@Override
	public Result<List<CatalogMessage>> queryPromotionIndex ()
	{
		i ("CATALOGRELATION", "queryPromotionIndex", LOG_TYPE_REQUEST, "");
		//查询首页营销广告
		List<String> catalogIds = catalogRelationMapper.queryPromotionCatalogId (1);
		i ("CATALOGRELATION", "queryPromotionIndex", "PROMOTIONCATALOGIDS", catalogIds);
		List<CatalogMessage> catalogMessages = Lists.newArrayList ();
		List<AdsMessage> adsMessages = null;
		if (! CollectionUtils.isEmpty (catalogIds))
		{
			CatalogMessage<AdsMessage> catalogMessage = null;
			AdsMessage adsMessage = null;
			for (String catalogId : catalogIds)
			{
				catalogMessage = new CatalogMessage<AdsMessage> ();
				i ("CATALOGRELATION", "queryPromotionIndex", "QUERYADSBYCATALOGID", catalogId);
				Map<String, Object> params = new HashMap<> ();
				params.put ("catalogId", catalogId);
				params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());
				List<CatalogAdsRela> catalogAdsRelas = catalogRelationMapper.queryPromotionAdByCatalogId (params);
				i ("CATALOGRELATION", "queryPromotionIndex", "QUERYADSBYCATALOGID", catalogAdsRelas);
				if (! CollectionUtils.isEmpty (catalogAdsRelas))
				{
					adsMessages = Lists.newArrayList ();
					for (CatalogAdsRela catalogAdsRela : catalogAdsRelas)
					{
						adsMessage = new AdsMessage ();
						BeanUtils.copyProperties (catalogAdsRela, adsMessage);
						adsMessages.add (adsMessage);
					}
					catalogMessage.setCatalogName (catalogAdsRelas.get (0).getCatalogName ());
					catalogMessage.setCatalogIcon (catalogAdsRelas.get (0).getCatalogIcon ());
					catalogMessage.setCatalogId (catalogAdsRelas.get (0).getCatalogId ());
					catalogMessage.setPosition (catalogAdsRelas.get (0).getPosition ());
					catalogMessage.setType (catalogAdsRelas.get (0).getType ());
					catalogMessage.setTarget (adsMessages);
					catalogMessages.add (catalogMessage);
				}
			}
		}

		//查询首页营销应用
		List<String> catalogAppIds = catalogRelationMapper.queryPromotionCatalogId (3);
		List<AppMessage> appMessages = null;
		if (! CollectionUtils.isEmpty (catalogAppIds))
		{
			CatalogMessage<AppMessage> catalogMessage = null;
			AppMessage appMessage = null;
			Map<String, Object> params = null;
			for (String catalogId : catalogAppIds)
			{
				catalogMessage = new CatalogMessage<AppMessage> ();
				params = Maps.newHashMap ();
				params.put ("catalogId", catalogId);
				params.put (DATA_PAGE_START, 0);
				params.put (DATA_PAGE_SIZE, 10);
				params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());
				i ("CATALOGRELATION", "qryCatalogAppRelation", LOG_TYPE_REQUEST, params);
				List<CatalogAppRela> catalogAppRelas = catalogRelationMapper.queryAppByCatalogId (params);
				i ("CATALOGRELATION", "qryCatalogAppRelation", LOG_TYPE_RESPONSE, catalogAppRelas);
				if (! CollectionUtils.isEmpty (catalogAppRelas))
				{
					appMessages = Lists.newArrayList ();
					for (CatalogAppRela catalogAppRela : catalogAppRelas)
					{
						appMessage = new AppMessage ();
						BeanUtils.copyProperties (catalogAppRela, appMessage);
						appMessages.add (appMessage);
					}
					catalogMessage.setCatalogName (catalogAppRelas.get (0).getCatalogName ());
					catalogMessage.setCatalogIcon (catalogAppRelas.get (0).getCatalogIcon ());
					catalogMessage.setCatalogId (catalogAppRelas.get (0).getCatalogId ());
					catalogMessage.setPosition (catalogAppRelas.get (0).getPosition ());
					catalogMessage.setType (catalogAppRelas.get (0).getType ());
					catalogMessage.setTarget (appMessages);
					catalogMessages.add (catalogMessage);
				}
			}
		}
		i ("CATALOGRELATION", "qryCatalogAppRelation", LOG_TYPE_RESPONSE, catalogMessages);
		return new Result<List<CatalogMessage>> ().success (catalogMessages);
	}

	/**
	 * 查询营销类广告信息
	 *
	 * @param type
	 * @return
	 */
	@Override
	public Result<List<AdsMessage>> queryPromotionAdsByType (@PathVariable ("type") Integer type)
	{
		if (null == type)
		{
			return new Result<> ().failure ("promotion type is null.");
		}
		i ("CATALOGRELATION", "queryPromotionAdsByType", "QUERYADSBYCATALOGID", type);
		Map<String, Object> params = new HashMap<> ();
		params.put ("type", type);
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());
		List<CatalogAdsRela> catalogAdsRelas = catalogRelationMapper.queryPromotionAdByType (params);
		i ("CATALOGRELATION", "queryPromotionAdsByType", "QUERYADSBYCATALOGID", catalogAdsRelas);
		List<AdsMessage> adsMessages = null;
		if (! CollectionUtils.isEmpty (catalogAdsRelas))
		{
			adsMessages = Lists.newArrayList ();
			AdsMessage adsMessage = null;
			for (CatalogAdsRela catalogAdsRela : catalogAdsRelas)
			{
				adsMessage = new AdsMessage ();
				BeanUtils.copyProperties (catalogAdsRela, adsMessage);
				adsMessages.add (adsMessage);
			}
		}
		return new Result<> ().success (adsMessages);
	}

	/**
	 * 查询营销HOT标签信息
	 *
	 * @return
	 */
	@Override
	public Result<CatalogMessage<CatalogMessage>> queryPromotionTagByType ()
	{
		CatalogMessage catalogMessage = null;
		i ("CATALOGRELATION", "queryPromotionTagByType", LOG_TYPE_REQUEST, "");
		Catalog catalog = catalogRelationMapper.queryHotCatalogTag (Language.getLanguage ());
		i ("CATALOGRELATION", "queryPromotionTagByType", LOG_TYPE_RESPONSE, catalog);
		if (null != catalog)
		{
			catalogMessage = new CatalogMessage ();
			catalogMessage.setCatalogId (catalog.getCatalogId ());
			catalogMessage.setCatalogName (catalog.getCatalogName ());
			catalogMessage.setCatalogIcon (catalog.getCatalogIcon ());
			i ("CATALOGRELATION", "queryHotTagsByCatalogId", LOG_TYPE_REQUEST, "");
			List<Catalog> catalogs = catalogRelationMapper
					.queryHotTagsByCatalogId (catalog.getCatalogId (), Language.getLanguage ());
			i ("CATALOGRELATION", "queryHotTagsByCatalogId", LOG_TYPE_RESPONSE, catalogs);
			if (! CollectionUtils.isEmpty (catalogs))
			{
				List<CatalogMessage> catalogMessages = Lists.newArrayList ();
				CatalogMessage catalogTag = null;
				for (Catalog hotCatalog : catalogs)
				{
					catalogTag = new CatalogMessage ();
					catalogTag.setCatalogId (hotCatalog.getCatalogId ());
					catalogTag.setCatalogName (hotCatalog.getCatalogName ());
					catalogTag.setCatalogIcon (hotCatalog.getCatalogIcon ());
					catalogMessages.add (catalogTag);
				}
				catalogMessage.setTarget (catalogMessages);
			}
		}
		i ("CATALOGRELATION", "queryHotTagsByCatalogId", LOG_TYPE_RESPONSE, catalogMessage);
		return new Result<> ().success (catalogMessage);
	}
}
