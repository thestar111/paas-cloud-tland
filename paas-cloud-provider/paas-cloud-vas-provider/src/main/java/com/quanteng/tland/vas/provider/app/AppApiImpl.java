/**
 * 文 件 名:  AppApiImpl
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2018/5/17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.provider.app;

import com.google.common.collect.Lists;
import com.quanteng.tland.cms.pojo.app.domain.AppsVo;
import com.quanteng.tland.cms.pojo.app.request.QueryAppRequest;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.AppMessage;
import com.quanteng.tland.cms.pojo.catalogrelation.domain.CatalogMessage;
import com.quanteng.tland.cms.pojo.catalogrelation.request.QryCatalogAppRelationRequest;
import com.quanteng.tland.common.annotation.Api;
import com.quanteng.tland.common.cons.Constants;
import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.vas.api.app.AppApi;
import com.quanteng.tland.vas.pojo.app.domain.AppBasicDto;
import com.quanteng.tland.vas.pojo.app.domain.AppDto;
import com.quanteng.tland.vas.pojo.app.request.FindAppByIdRequest;
import com.quanteng.tland.vas.pojo.app.request.SearchAppByNameRequest;
import com.quanteng.tland.vas.pojo.catalogrelation.domain.NormalCatalogDto;
import com.quanteng.tland.vas.pojo.catalogrelation.request.QueryAppByCatalogIdRequest;
import com.quanteng.tland.vas.service.app.AppService;
import com.quanteng.tland.vas.service.catalog.CatalogService;
import com.quanteng.tland.vas.service.catalogrelation.CatalogRelationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.quanteng.tland.common.log.TlandLogger.*;

/**
 * <app接口功能实现>
 *
 * @author zhengbinggui
 * @version 2018/5/17
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Api
public class AppApiImpl implements AppApi
{

	@Autowired
	private AppService appService;

	@Autowired
	private CatalogService catalogService;

	@Autowired
	private CatalogRelationService catalogRelationService;

	/**
	 * 根据栏目编号查询应用信息(不包括栏目分类下的二级栏目分类)
	 * 供客户端查询首页配置的栏目分类，栏目推荐页的TOP，NEW，HOT这些营销栏目下的应用信息查询
	 *
	 * @param queryAppByCatalogIdRequest
	 * @return
	 */
	@Override
	public Result<NormalCatalogDto<AppBasicDto>> queryAppByCatalogId (
			QueryAppByCatalogIdRequest queryAppByCatalogIdRequest)
	{
		if (null == queryAppByCatalogIdRequest || StringUtils.isEmpty (queryAppByCatalogIdRequest.getCatalogId ()))
		{
			return new Result<> ().failure ("queryAppByCatalogId illegal params");
		}
		//构造cms请求类
		QryCatalogAppRelationRequest qryCatalogAppRelationRequest = new QryCatalogAppRelationRequest ();
		qryCatalogAppRelationRequest.setCatalogId (queryAppByCatalogIdRequest.getCatalogId ());
		qryCatalogAppRelationRequest.setPageIndex (queryAppByCatalogIdRequest.getPageIndex ());
		qryCatalogAppRelationRequest.setPageSize (queryAppByCatalogIdRequest.getPageSize ());
		//查询cms
		i ("APP", "queryAppByCatalogId", LOG_TYPE_REQUEST, queryAppByCatalogIdRequest);
		Result<CatalogMessage<AppMessage>> serviceResult = catalogRelationService
				.qryAppByAppCatalogId (qryCatalogAppRelationRequest);
		//定义返回结果集
		Result<NormalCatalogDto<AppBasicDto>> result = new Result<> ();

		if (null != serviceResult && (Constants.ResultCode.SUCCESS).equals (serviceResult.getResultCode ()))
		{
			CatalogMessage<AppMessage> catalogMessage = serviceResult.getData ();
			if (null != serviceResult.getData ())
			{
				NormalCatalogDto<AppBasicDto> catalogDto = new NormalCatalogDto<> ();
				catalogDto.setCatalogId (catalogMessage.getCatalogId ());
				catalogDto.setCatalogName (catalogMessage.getCatalogName ());
				catalogDto.setCatalogIcon (catalogMessage.getCatalogIcon ());
				List<AppBasicDto> appDtoList = Lists.newArrayList ();
				if (! CollectionUtils.isEmpty (catalogMessage.getTarget ()))
				{
					catalogMessage.getTarget ().forEach (appMessage -> {
						AppBasicDto appDto = new AppBasicDto ();
						BeanUtils.copyProperties (appMessage, appDto);
						appDtoList.add (appDto);
					});
				}
				catalogDto.setTarget (appDtoList);
				result.setTotalCount (serviceResult.getTotalCount ());
				result.setData (catalogDto);
			}
		}
		else
		{
			result.setResultMessage ("queryAppByCatalogId CMSServcis Return Data Is Null Or ReturnCode No Zero");
		}

		i ("APP", "queryAppByCatalogId", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 根据二级栏目编号查询应用信息(只供二级栏目分类下的栏目分类编号查询)
	 * 供客户端查询二级栏目分类查询该栏目下的应用信息
	 *
	 * @param queryAppByCatalogIdRequest
	 * @return
	 */
	@Override
	public Result<NormalCatalogDto<AppBasicDto>> queryAppBySubCatalogId (
			QueryAppByCatalogIdRequest queryAppByCatalogIdRequest)
	{

		i ("APP", "queryAppBySubCatalogId", LOG_TYPE_REQUEST, queryAppByCatalogIdRequest);
		if (null == queryAppByCatalogIdRequest || StringUtils.isEmpty (queryAppByCatalogIdRequest.getCatalogId ()))
		{
			return new Result<> ().failure ("queryAppBySubCatalogId illegal params");
		}

		//查询cms
		Result<CatalogMessage<AppMessage>> serviceResult = catalogService
				.queryAppsBySubCatalog (queryAppByCatalogIdRequest.getCatalogId (),
						queryAppByCatalogIdRequest.getPageIndex (), queryAppByCatalogIdRequest.getPageSize ());
		//定义返回结果集
		Result<NormalCatalogDto<AppBasicDto>> result = new Result<> ();

		if (null != serviceResult && (Constants.ResultCode.SUCCESS).equals (serviceResult.getResultCode ()))
		{
			CatalogMessage<AppMessage> catalogMessage = serviceResult.getData ();
			if (null != serviceResult.getData ())
			{
				NormalCatalogDto<AppBasicDto> catalogDto = new NormalCatalogDto<> ();
				BeanUtils.copyProperties (catalogMessage, catalogDto);
				List<AppBasicDto> appDtoList = Lists.newArrayList ();
				if (! CollectionUtils.isEmpty (catalogMessage.getTarget ()))
				{
					AppBasicDto appDto = null;
					for (AppMessage appMessage : catalogMessage.getTarget ())
					{
						appDto = new AppBasicDto ();
						BeanUtils.copyProperties (appMessage, appDto);
						appDtoList.add (appDto);
					}
				}
				catalogDto.setTarget (appDtoList);
				result.setTotalCount (serviceResult.getTotalCount ());
				result.setData (catalogDto);
			}
		}
		else
		{
			result.setResultMessage ("queryAppBySubCatalogId CMSServcis Return Data Is Null Or ReturnCode No Zero");
		}

		i ("APP", "queryAppBySubCatalogId", LOG_TYPE_RESPONSE, result);
		return result;

	}

	/**
	 * 根据应用名称搜索
	 * 供客户端根据应用名称搜索应用接口
	 *
	 * @param searchAppByNameRequest
	 * @return
	 */
	@Override
	public Result<List<AppBasicDto>> queryAppByName (SearchAppByNameRequest searchAppByNameRequest)
	{
		i ("APP", "queryAppByName", LOG_TYPE_REQUEST, searchAppByNameRequest);
		if (null == searchAppByNameRequest)
		{
			return new Result<> ().failure ("querAppByName illegal params");
		}

		//构造cms请求
		QueryAppRequest queryAppRequest = new QueryAppRequest ();
		queryAppRequest.setAppName (searchAppByNameRequest.getAppName ());
		queryAppRequest.setPageIndex (searchAppByNameRequest.getPageIndex ());
		queryAppRequest.setPageSize (searchAppByNameRequest.getPageSize ());
		//查询cms
		Result<List<AppsVo>> serviceResult = appService.queryList (queryAppRequest);
		//定义返回结果集
		Result<List<AppBasicDto>> result = new Result<> ();
		List<AppBasicDto> appDtoList = Lists.newArrayList ();
		//转换cms返回信息
		if (null != serviceResult && (Constants.ResultCode.SUCCESS).equals (serviceResult.getResultCode ()))
		{
			List<AppsVo> appsVoList = serviceResult.getData ();
			if (! CollectionUtils.isEmpty (appsVoList))
			{
				appsVoList.forEach (app -> {
					AppBasicDto appDto = new AppBasicDto ();
					BeanUtils.copyProperties (app, appDto);
					appDtoList.add (appDto);
				});
				result.setData (appDtoList);
				result.setTotalCount (serviceResult.getTotalCount ());
			}
		}
		else
		{
			result.setResultMessage ("queryAppByName CMSServcis Return Data Is Null Or ReturnCode No Zero");
		}
		i ("APP", "queryAppByName", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 根据ID查询应用  供客户端使用
	 *
	 * @param findAppByIdRequest
	 * @return
	 */
	@Override
	public Result<AppDto> findAppById (FindAppByIdRequest findAppByIdRequest)
	{
		i ("APP", "findAppById", LOG_TYPE_REQUEST, findAppByIdRequest);
		if (null == findAppByIdRequest)
		{
			return new Result<AppDto> ().failure ("findAppById illegal params");
		}
		//去cms查
		Result<AppsVo> serviceResult = appService.findAppById (findAppByIdRequest.getAppId ());
		//定义返回信息
		Result<AppDto> result = new Result<AppDto> ();

		AppDto appDto = new AppDto ();
		if (null != serviceResult && (Constants.ResultCode.SUCCESS).equals (serviceResult.getResultCode ()))
		{
			if (null != serviceResult.getData ())
			{
				//实体转换
				BeanUtils.copyProperties (serviceResult.getData (), appDto);
				appDto.setAppContent (serviceResult.getData ().getContent ());
				result.setData (appDto);
			}
		}
		else
		{
			result.setResultMessage ("findAppById CMSServcis Return Data Is Null Or ReturnCode No Zero");
		}
		i ("APP", "findAppById", LOG_TYPE_RESPONSE, result);
		return result;
	}
}
