/**
 * 文 件 名:  CatalogRelationApiImpl
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.provider.catalogrelation;

import com.google.common.collect.Lists;
import com.quanteng.tland.cms.pojo.catalog.domain.CatalogVo;
import com.quanteng.tland.cms.pojo.catalog.request.QueryCatalogRequest;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.AdsMessage;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.AppMessage;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.CatalogMessage;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.CatalogMessageVo;
import com.quanteng.tland.common.annotation.Api;
import com.quanteng.tland.common.cons.Constants;
import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.vas.api.catalogrelation.CatalogRelationApi;
import com.quanteng.tland.vas.pojo.ads.domain.AdsDto;
import com.quanteng.tland.vas.pojo.app.domain.AppBasicDto;
import com.quanteng.tland.vas.pojo.app.domain.AppDto;
import com.quanteng.tland.vas.pojo.catalogrelation.domain.*;
import com.quanteng.tland.vas.pojo.catalogrelation.request.QueryAppByCatalogTypeRequest;
import com.quanteng.tland.vas.pojo.catalogrelation.request.QueryPromotionAdsByTypeRequest;
import com.quanteng.tland.vas.pojo.catalogrelation.request.QuerySubCatalogByIdRequest;
import com.quanteng.tland.vas.service.catalog.CatalogService;
import com.quanteng.tland.vas.service.catalogrelation.CatalogRelationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.quanteng.tland.common.log.TlandLogger.*;

/**
 * <栏目应用关系接口实现类>
 *
 * @author LJun
 * @version 2018/5/17
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Api
public class CatalogRelationApiImpl implements CatalogRelationApi
{
	@Autowired
	private CatalogService catalogService;
	@Autowired
	private CatalogRelationService catalogRelationService;

	/**
	 * 栏目分类列表查询
	 * 供APP端查询分类页展示信息，此信息在运营管理系统端可以配置一级栏目二级栏目之间的关系，并设置好二级栏目排序位置等
	 *
	 * @return
	 */
	@Override
	public Result<List<ParentCatalogDto>> queryCatalogList ()
	{
		i ("CATALOGRELATION", "queryCatalogList", LOG_TYPE_REQUEST, "begin");
		Result<List<CatalogMessageVo>> serviceResult = catalogService.queryCatalogInfo ();
		i ("CATALOGRELATION", "queryCatalogList", LOG_TYPE_RESPONSE, serviceResult);

		List<ParentCatalogDto> parentCatalogPojos = null;
		List<SubCatalogDto> subCatalogList = null;

		if (null != serviceResult && (Constants.ResultCode.SUCCESS).equals (serviceResult.getResultCode ()))
		{
			List<CatalogMessageVo> catalogMessageVoList = serviceResult.getData ();
			if (! CollectionUtils.isEmpty (catalogMessageVoList))
			{
				parentCatalogPojos = Lists.newArrayList ();
				ParentCatalogDto parentCatalog = null;
				SubCatalogDto subCatalogPojo = null;
				for (CatalogMessageVo catalogMessageVo : catalogMessageVoList)
				{
					parentCatalog = new ParentCatalogDto ();
					BeanUtils.copyProperties (catalogMessageVo, parentCatalog);
					if (! CollectionUtils.isEmpty (catalogMessageVo.getSubCatalog ()))
					{
						subCatalogList = Lists.newArrayList ();
						for (CatalogMessageVo subMessageVo : catalogMessageVo.getSubCatalog ())
						{
							subCatalogPojo = new SubCatalogDto ();
							BeanUtils.copyProperties (subMessageVo, subCatalogPojo);
							subCatalogList.add (subCatalogPojo);
						}
						parentCatalog.setSubCatalog (subCatalogList);
					}
					parentCatalogPojos.add (parentCatalog);
				}
			}
		}
		return new Result<> ().success (parentCatalogPojos);
	}

	/**
	 * 根据栏目编号查询子栏目信息
	 * 供二级栏目查询应用信息
	 *
	 * @param querySubCatalogById
	 * @return
	 */
	@Override
	public Result<List<NormalCatalogDto<AppBasicDto>>> querySubCatalog (QuerySubCatalogByIdRequest querySubCatalogById)
	{
		i ("CATALOGRELATION", "querySubCatalog", LOG_TYPE_REQUEST, querySubCatalogById);
		if (null == querySubCatalogById || StringUtils.isEmpty (querySubCatalogById.getCatalogId ()))
		{
			return new Result<> ().failure ("querySubCatalog illegal params");
		}

		//查询cms
		Result<List<CatalogMessage<AppMessage>>> serviceResult = catalogService
				.querySubCatalogInfo (querySubCatalogById.getCatalogId ());
		//定义返回结果集
		Result<List<NormalCatalogDto<AppBasicDto>>> result = new Result<> ();
		List<NormalCatalogDto<AppBasicDto>> normalCatalogDtos = Lists.newArrayList ();

		if (null != serviceResult && (Constants.ResultCode.SUCCESS).equals (serviceResult.getResultCode ()))
		{
			List<CatalogMessage<AppMessage>> catalogMessageList = serviceResult.getData ();
			if (! CollectionUtils.isEmpty (catalogMessageList))
			{
				NormalCatalogDto normalCatalogDto = null;
				List<AppBasicDto> appDtoList = null;
				AppBasicDto appDto = null;
				for (CatalogMessage catalogMessage : catalogMessageList)
				{
					normalCatalogDto = new NormalCatalogDto ();
					BeanUtils.copyProperties (catalogMessage, normalCatalogDto);
					if (! CollectionUtils.isEmpty (catalogMessage.getTarget ()))
					{
						appDtoList = Lists.newArrayList ();
						List<AppMessage> appMessageList = catalogMessage.getTarget ();
						for (AppMessage appMessage : appMessageList)
						{
							appDto = new AppBasicDto ();
							BeanUtils.copyProperties (appMessage, appDto);
							appDtoList.add (appDto);
						}
						normalCatalogDto.setTarget (appDtoList);
					}
					normalCatalogDtos.add (normalCatalogDto);
				}
			}
			result.setData (normalCatalogDtos);
		}
		else
		{
			result.setResultMessage ("querySubCatalog CMSServcis Return Data Is Null Or ReturnCode No Zero");
		}

		i ("CATALOGRELATION", "querySubCatalog", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 根据应用栏目分类查询应用信息
	 * 供客户端查询应用信息，根据栏目营销类型：(TOP, NEW, HOT 属于应用栏目信息)
	 *
	 * @param queryAppByCatalogTypeRequest
	 * @return
	 */
	@Override
	public Result<List<CatalogDto>> queryCatalogsByType (QueryAppByCatalogTypeRequest queryAppByCatalogTypeRequest)
	{
		i ("CATALOGRELATION", "queryCatalogsByType", LOG_TYPE_REQUEST, queryAppByCatalogTypeRequest);
		if (null == queryAppByCatalogTypeRequest)
		{
			return new Result<CatalogDto> ().failure ("queryCatalogsByType illegal params");
		}
		//构造cms请求
		QueryCatalogRequest queryCatalogRequest = new QueryCatalogRequest ();
		queryCatalogRequest.setType (queryAppByCatalogTypeRequest.getType ());
		queryCatalogRequest.setPageIndex (queryAppByCatalogTypeRequest.getPageIndex ());
		queryCatalogRequest.setPageSize (queryAppByCatalogTypeRequest.getPageSize ());
		//查询cms
		Result<List<CatalogVo>> serviceResult = catalogService.queryByCondition (queryCatalogRequest);
		//定义返回结果集
		Result<List<CatalogDto>> result = new Result<List<CatalogDto>> ();
		List<CatalogDto> catalogDtoList = Lists.newArrayList ();
		if (null != serviceResult && (Constants.ResultCode.SUCCESS).equals (serviceResult.getResultCode ()))
		{
			List<CatalogVo> catalogVoList = serviceResult.getData ();
			if (! CollectionUtils.isEmpty (catalogVoList))
			{
				CatalogDto catalogDto = null;
				for (CatalogVo catalogVo : catalogVoList)
				{
					catalogDto = new CatalogDto ();
					BeanUtils.copyProperties (catalogVo, catalogDto);
					catalogDtoList.add (catalogDto);
				}
				result.setData (catalogDtoList);
				result.setTotalCount (serviceResult.getTotalCount ());
			}
		}
		else
		{
			result.setResultMessage ("queryCatalogsByType CMSServcis Return Data Is Null Or ReturnCode No Zero");
		}

		i ("CATALOGRELATION", "queryCatalogsByType", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 查询营销广告信息
	 * 供客户端查询可配置的不同页面下的营销广告信息
	 *
	 * @param queryPromotionAdsByTypeRequest
	 * @return
	 */
	@Override
	public Result<List<AdsDto>> queryPromotionAdsByType (QueryPromotionAdsByTypeRequest queryPromotionAdsByTypeRequest)
	{
		i ("CATALOGRELATION", "queryPromotionAdsByType", LOG_TYPE_REQUEST, queryPromotionAdsByTypeRequest);
		if (null == queryPromotionAdsByTypeRequest)
		{
			return new Result<List<AdsDto>> ().failure ("queryPromotionAdsByType illegal params");
		}
		//查询cms
		Result<List<AdsMessage>> serviceResult = catalogRelationService
				.queryPromotionAdsByType (queryPromotionAdsByTypeRequest.getType ());
		//定义返回结果集
		Result<List<AdsDto>> result = new Result<List<AdsDto>> ();

		if (null != serviceResult && (Constants.ResultCode.SUCCESS).equals (serviceResult.getResultCode ()))
		{
			List<AdsMessage> adsMessageList = serviceResult.getData ();
			List<AdsDto> adsDtoList = Lists.newArrayList ();
			if (! CollectionUtils.isEmpty (adsMessageList))
			{
				adsMessageList.forEach (adsMessage -> {
					AdsDto adsDto = new AdsDto ();
					BeanUtils.copyProperties (adsMessage, adsDto);
					adsDto.setType (adsMessage.getAdvertisementType ());
					adsDtoList.add (adsDto);
				});
				result.setData (adsDtoList);
			}
		}
		else
		{
			result.setResultMessage ("queryPromotionAdsByType CMSServcis Return Data Is Null Or ReturnCode No Zero");
		}

		i ("CATALOGRELATION", "queryPromotionAdsByType", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 获取HOT热门推荐应用栏目分类信息(HOT TAG)
	 * 供客户端根据应用名称搜索应用接口
	 *
	 * @return
	 */
	@Override
	public Result<ParentCatalogDto> queryHotTag ()
	{
		i ("CATALOGRELATION", "queryHotTag", LOG_TYPE_REQUEST, "begin");
		//查询cms
		Result<CatalogMessage<CatalogMessage>> serviceResult = catalogRelationService.queryPromotionTagByType ();
		//定义返回结果集
		Result<ParentCatalogDto> result = new Result<> ();

		if (null != serviceResult && (Constants.ResultCode.SUCCESS).equals (serviceResult.getResultCode ()))
		{
			CatalogMessage<CatalogMessage> catalogMessage = serviceResult.getData ();
			ParentCatalogDto parentCatalogDto = new ParentCatalogDto ();
			BeanUtils.copyProperties (catalogMessage, parentCatalogDto);
			List<CatalogMessage> catalogMessageList = catalogMessage.getTarget ();
			if (! CollectionUtils.isEmpty (catalogMessageList))
			{
				List<SubCatalogDto> subCatalogDtos = Lists.newArrayList ();
				SubCatalogDto subCatalogDto = null;
				for (CatalogMessage subCatalogMessage : catalogMessageList)
				{
					subCatalogDto = new SubCatalogDto ();
					BeanUtils.copyProperties (subCatalogMessage, subCatalogDto);
					subCatalogDtos.add (subCatalogDto);
				}
				parentCatalogDto.setSubCatalog (subCatalogDtos);
				result.setData (parentCatalogDto);
			}
		}
		else
		{
			result.setResultMessage ("queryPromotionAdsByType CMSServcis Return Data Is Null Or ReturnCode No Zero");
		}
		i ("CATALOGRELATION", "queryHotTag", LOG_TYPE_RESPONSE, result);
		return result;
	}
}
