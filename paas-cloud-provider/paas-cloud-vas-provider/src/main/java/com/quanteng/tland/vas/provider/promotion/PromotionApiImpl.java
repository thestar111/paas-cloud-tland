/**
 * 文 件 名:  PromotionApiImpl
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.provider.promotion;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.AdsMessage;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.AppMessage;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.CatalogMessage;
import com.quanteng.tland.common.annotation.Api;
import com.quanteng.tland.common.cons.Constants;
import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.vas.api.promotion.PromotionApi;
import com.quanteng.tland.vas.pojo.promotion.domain.AdsPromotionDto;
import com.quanteng.tland.vas.pojo.promotion.domain.AppPromotionDto;
import com.quanteng.tland.vas.pojo.promotion.domain.CatalogPromotionDto;
import com.quanteng.tland.vas.service.catalogrelation.CatalogRelationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.quanten.core.utils.JSONSerialize.OBJECT_MAPPER;
import static com.quanteng.tland.common.log.TlandLogger.i;

/**
 * <首页营销接口实现类>
 *
 * @author LJun
 * @version 2018/5/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Api
public class PromotionApiImpl implements PromotionApi
{
	@Autowired
	private CatalogRelationService catalogRelationService;
	/**
	 * 首页栏目广告类型
	 */
	public static final Integer INDEX_CATALOG_AD_TYPE = 1;

	/**
	 * 首页栏目应用类型
	 */
	public static final Integer INDEX_CATALOG_APP_TYPE = 3;

	/**
	 * 查询首页展示信息
	 *
	 * @return
	 */
	@Override
	public Result<List<CatalogPromotionDto>> queryPromotionIndex ()
	{
		Result<List<CatalogPromotionDto>> result = new Result<> ();

		Result<List<CatalogMessage>> serviceResult = catalogRelationService.queryPromotionIndex ();
		i ("PROMOTION", "queryPromotionIndex", "cms response", serviceResult);

		if (null != serviceResult && Constants.ResultCode.SUCCESS.equals (serviceResult.getResultCode ()))
		{
			List<CatalogMessage> catalogMessages = serviceResult.getData ();
			if (! CollectionUtils.isEmpty (catalogMessages))
			{
				List<CatalogPromotionDto> catalogPromotionDtos = Lists.newArrayList ();
				for (CatalogMessage catalogMessage : catalogMessages)
				{
					CatalogPromotionDto catalogPromotionDto = null;
					if (INDEX_CATALOG_AD_TYPE.equals (catalogMessage.getType ()))
					{
						catalogPromotionDto = new CatalogPromotionDto<List<AdsPromotionDto>> ();
						catalogPromotionDto.setCatalogId (catalogMessage.getCatalogId ());
						catalogPromotionDto.setCatalogIcon (catalogMessage.getCatalogIcon ());
						catalogPromotionDto.setCatalogName (catalogMessage.getCatalogName ());
						catalogPromotionDto.setPosition (catalogMessage.getPosition ());
						catalogPromotionDto.setType (catalogMessage.getType ());
						if (! CollectionUtils.isEmpty (catalogMessage.getTarget ()))
						{
							List<AdsPromotionDto> adsPromotionDtos = Lists.newArrayList ();
							List<AdsMessage> adsMessages = OBJECT_MAPPER
									.convertValue (catalogMessage.getTarget (), new TypeReference<List<AdsMessage>> ()
									{
									});
							for (AdsMessage adsMessage : adsMessages)
							{
								AdsPromotionDto adsPromotionDto = new AdsPromotionDto ();
								adsPromotionDto.setAdvertisementId (adsMessage.getAdvertisementId ());
								adsPromotionDto.setAdvertisementName (adsMessage.getAdvertisementName ());
								adsPromotionDto.setAdvertisementUrl (adsMessage.getAdvertisementUrl ());
								adsPromotionDto.setImgUrl (adsMessage.getImgUrl ());
								adsPromotionDto.setType (adsMessage.getAdvertisementType ());
								adsPromotionDto.setOrder (adsMessage.getOrder ());
								adsPromotionDto.setTargetId (adsMessage.getTargetId ());
								adsPromotionDtos.add (adsPromotionDto);
							}
							catalogPromotionDto.setTarget (adsPromotionDtos);
						}
					}
					else if (INDEX_CATALOG_APP_TYPE.equals (catalogMessage.getType ()))
					{
						catalogPromotionDto = new CatalogPromotionDto<List<AppPromotionDto>> ();
						catalogPromotionDto.setCatalogId (catalogMessage.getCatalogId ());
						catalogPromotionDto.setCatalogIcon (catalogMessage.getCatalogIcon ());
						catalogPromotionDto.setCatalogName (catalogMessage.getCatalogName ());
						catalogPromotionDto.setPosition (catalogMessage.getPosition ());
						catalogPromotionDto.setType (catalogMessage.getType ());
						if (! CollectionUtils.isEmpty (catalogMessage.getTarget ()))
						{
							List<AppPromotionDto> appPromotionDtos = Lists.newArrayList ();
							List<AppMessage> appMessages = OBJECT_MAPPER
									.convertValue (catalogMessage.getTarget (), new TypeReference<List<AppMessage>> ()
									{
									});
							for (AppMessage appMessage : appMessages)
							{
								AppPromotionDto appPromotionDto = new AppPromotionDto ();
								BeanUtils.copyProperties (appMessage, appPromotionDto);
								appPromotionDtos.add (appPromotionDto);
							}
							catalogPromotionDto.setTarget (appPromotionDtos);
						}
					}
					catalogPromotionDtos.add (catalogPromotionDto);
				}
				result.setData (catalogPromotionDtos);
			}
			result.success ();
		}
		else
		{
			result.failure (
					null == serviceResult ? "Query catalog relation failed" : serviceResult.getResultMessage ());
		}
		return result;
	}
}
