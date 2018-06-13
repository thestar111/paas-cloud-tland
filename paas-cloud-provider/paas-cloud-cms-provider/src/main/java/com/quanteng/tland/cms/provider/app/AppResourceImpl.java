/**
 * 文 件 名:  AppResourceImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/25 0025
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.app;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.quanten.core.utils.GenerateSequenceID;
import com.quanteng.tland.cms.api.app.AppResource;
import com.quanteng.tland.cms.database.entity.App;
import com.quanteng.tland.cms.database.entity.AppLang;
import com.quanteng.tland.cms.database.mapper.AppMapper;
import com.quanteng.tland.cms.database.mapper.CatalogRelationMapper;
import com.quanteng.tland.cms.pojo.app.domain.AppLangVo;
import com.quanteng.tland.cms.pojo.app.domain.AppModel;
import com.quanteng.tland.cms.pojo.app.domain.AppsVo;
import com.quanteng.tland.cms.pojo.app.request.AddAppRequest;
import com.quanteng.tland.cms.pojo.app.request.BatchModifyAppStatusRequest;
import com.quanteng.tland.cms.pojo.app.request.ModifyAppRequest;
import com.quanteng.tland.cms.pojo.app.request.QueryAppRequest;
import com.quanteng.tland.cms.pojo.app.response.BatchModifyAppStatusResponse;
import com.quanteng.tland.cms.pojo.app.response.QueryAppListResponse;
import com.quanteng.tland.cms.provider.mapper.EntityMapperInstance;
import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.common.thread.Language;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.quanteng.tland.common.cons.Constants.Cons.*;
import static com.quanteng.tland.common.log.TlandLogger.*;

/**
 * <游戏应用资源实现接口>
 *
 * @author zping
 * @version 2018/4/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class AppResourceImpl implements AppResource
{

	@Autowired
	private AppMapper appMapper;

	@Autowired
	private CatalogRelationMapper catalogRelationMapper;

	/**
	 * 添加游戏应用信息modifyAppStatus
	 *
	 * @param addAppRequest
	 * @return
	 */
	@Override
	public Result add (@RequestBody AddAppRequest addAppRequest)
	{
		i ("APP", "add", LOG_TYPE_REQUEST, addAppRequest);
		if (null == addAppRequest || null == addAppRequest.getApps ())
		{
			return new Result ().failure ("illega params");
		}

		AppsVo appsVo = addAppRequest.getApps ();
		String appId = GenerateSequenceID.getSeqID ();
		App app = new App ();
		BeanUtils.copyProperties (appsVo, app);
		app.setAppId (appId);
		int flag = appMapper.add (app);
		if (0 < flag)
		{
			List<AppLangVo> appLangVos = appsVo.getAppLangs ();
			if (! CollectionUtils.isEmpty (appLangVos))
			{
				List<AppLang> appLangs = Lists.newArrayList ();
				appLangVos.forEach (appLangVo -> {
					AppLang appLang = EntityMapperInstance.INSTANCE.appLangToEntity (appLangVo);
					appLang.setAppId (appId);
					appLangs.add (appLang);
				});
				flag = appMapper.addAppLang (appLangs);
				if (0 < flag)
				{
					return new Result ().success ();
				}
				else
				{
					return new Result ().failure ("add app failed.");
				}
			}
			else
			{
				return new Result ().success ();
			}
		}
		else
		{
			return new Result ().failure ("add app failed.");
		}
	}

	/**
	 * 更新
	 *
	 * @param modifyAppRequest
	 * @return
	 */
	@Override
	public Result modify (@RequestBody ModifyAppRequest modifyAppRequest)
	{
		i ("APP", "modify", LOG_TYPE_REQUEST, modifyAppRequest);
		if (null == modifyAppRequest || null == modifyAppRequest.getApps ())
		{
			return new Result ().failure ("illega params");
		}

		if (StringUtils.isEmpty (modifyAppRequest.getApps ().getAppId ()))
		{
			return new Result ().failure ("appId illega params");
		}

		App app = new App ();
		BeanUtils.copyProperties (modifyAppRequest.getApps (), app);
		int flag = appMapper.modify (app);

		if (0 < flag)
		{
			List<AppLangVo> appLangVos = modifyAppRequest.getApps ().getAppLangs ();
			if (! CollectionUtils.isEmpty (appLangVos))
			{
				List<AppLang> appLangs = Lists.newArrayList ();
				AppLang appLang = null;
				for (AppLangVo appLangVo : appLangVos)
				{
					appLang = EntityMapperInstance.INSTANCE.appLangToEntity (appLangVo);
					appLangs.add (appLang);
				}
				flag = appMapper.modifyAppLang (appLangs);
				if (0 < flag)
				{
					return new Result ().success ();
				}
				else
				{
					return new Result ().failure ("modify app failed.");
				}
			}
			else
			{
				return new Result ().success ();
			}
		}
		else
		{
			return new Result ().failure ("modify app failed.");
		}
	}

	/**
	 * 多条件查询
	 *
	 * @param queryAppRequest
	 * @return
	 */
	@Override
	public Result<List<AppsVo>> queryList (@RequestBody QueryAppRequest queryAppRequest)
	{
		i ("APP", "queryList", LOG_TYPE_REQUEST, queryAppRequest);
		Result<List<AppsVo>> result = new Result<List<AppsVo>> ();
		Map<String, Object> params = Maps.newHashMap ();

		if (! StringUtils.isEmpty (queryAppRequest.getAppName ()))
		{
			params.put ("appName", queryAppRequest.getAppName ());
		}

		if (! StringUtils.isEmpty (queryAppRequest.getCatalogId ()))
		{
			params.put ("catalogId", queryAppRequest.getCatalogId ());
		}

		if (! StringUtils.isEmpty (queryAppRequest.getAppStatus ()))
		{
			params.put ("appStatus", queryAppRequest.getAppStatus ());
		}

		if (! StringUtils.isEmpty (queryAppRequest.getCpId ()))
		{
			params.put ("cpId", queryAppRequest.getCpId ());
		}

		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());
		params.put (DATA_PAGE_START, (queryAppRequest.getPageIndex () - 1) * queryAppRequest.getPageSize ());
		params.put (DATA_PAGE_SIZE, queryAppRequest.getPageSize ());

		List<App> apps = appMapper.queryListByCondition (params);
		List<AppsVo> appsVoLists = Lists.newArrayList ();
		if (! CollectionUtils.isEmpty (apps))
		{
			AppsVo appsVo = null;
			for (App app : apps)
			{
				appsVo = new AppsVo ();
				BeanUtils.copyProperties (app, appsVo);
				appsVoLists.add (appsVo);
			}
			result.setData (appsVoLists);
			result.setTotalCount (appMapper.queryCountByCondition (params));
		}
		result.success ();
		i ("APP", "queryList", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 根据营销分类编号查询
	 *
	 * @param catalogId 分类编号
	 * @param start     开始索引
	 * @param size      分页大小
	 * @return
	 */
	@Override
	public Result<List<AppsVo>> queryByPromotionCatalogId (@PathVariable ("catalog") String catalogId,
			@PathVariable ("start") Integer start, @PathVariable ("size") Integer size)
	{
		if (StringUtils.isEmpty (catalogId))
		{
			return new Result<QueryAppListResponse> ().failure ("catalogId is Illega params");
		}
		Result<List<AppsVo>> result = new Result<List<AppsVo>> ();
		List<App> apps = appMapper
				.queryByPromotionCatalogId (catalogId, Language.getLanguage (), (start - 1) * size, size);
		List<AppsVo> appsVos = Lists.newArrayList ();
		if (! CollectionUtils.isEmpty (apps))
		{
			apps.forEach (app -> {
				AppsVo appsVo = new AppsVo ();
				BeanUtils.copyProperties (app, appsVo);
				appsVos.add (appsVo);
			});
			result.setData (appsVos);
			result.setTotalCount (appMapper.queryCountByPromotionColumnId (catalogId));
		}
		result.success ();
		return result;
	}

	/**
	 * 根据游戏普通分类，状态查询
	 *
	 * @param catalogId 分类编号
	 * @param start     开始索引
	 * @param size      分页大小
	 * @return
	 */
	@Override
	public Result<List<AppsVo>> queryAppByNormalCatalog (@PathVariable ("catalog") String catalogId,
			@PathVariable ("start") Integer start, @PathVariable ("size") Integer size)
	{
		if (StringUtils.isEmpty (catalogId))
		{
			return new Result<List<AppsVo>> ().failure ("catalogId is Illega params");
		}

		Result<List<AppsVo>> result = new Result<List<AppsVo>> ();
		List<App> apps = appMapper
				.queryAppByNormalCatalog (catalogId, Language.getLanguage (), (start - 1) * size, size);
		List<AppsVo> appsVos = Lists.newArrayList ();
		if (! CollectionUtils.isEmpty (apps))
		{
			apps.forEach (app -> {
				AppsVo appsVo = new AppsVo ();
				BeanUtils.copyProperties (app, appsVo);
				appsVos.add (appsVo);
			});
			result.setData (appsVos);
			result.setTotalCount (appMapper.queryCountByColumnId (catalogId));
		}
		result.success ();
		return result;
	}

	/**
	 * 根据ID查询应用 供平台使用
	 *
	 * @param appId
	 * @return
	 */
	@Override
	public Result<AppsVo> queryAppById (@PathVariable ("appId") String appId)
	{
		i ("APP", "queryAppById", LOG_TYPE_REQUEST, appId);
		if (StringUtils.isEmpty (appId))
		{
			return new Result<AppsVo> ().failure ("appId illega params");
		}
		Result<AppsVo> result = new Result<> ();
		App app = appMapper.queryById (appId);
		AppsVo appsVo = null;
		if (null != app)
		{
			appsVo = new AppsVo ();
			BeanUtils.copyProperties (app, appsVo);

			List<AppLang> appLangs = appMapper.queryAppLangById (appId);

			if (! CollectionUtils.isEmpty (appLangs))
			{
				List<AppLangVo> appLangVos = Lists.newArrayList ();
				appLangs.forEach (appLang -> {
					AppLangVo appLangVo = EntityMapperInstance.INSTANCE.appLangToVO (appLang);
					appLangVos.add (appLangVo);
				});
				appsVo.setAppLangs (appLangVos);
			}
		}
		result.success (appsVo);

		i ("APP", "queryAppById", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 根据ID查询应用  供客户端使用
	 *
	 * @param appId
	 * @return
	 */
	@Override
	public Result<AppsVo> findAppById (@PathVariable ("appId") String appId)
	{
		if (StringUtils.isEmpty (appId))
		{
			return new Result<AppsVo> ().failure ("appId illega params");
		}
		Result<AppsVo> result = new Result<> ();
		App app = appMapper.findById (appId, Language.getLanguage ());
		AppsVo appsVo = new AppsVo ();
		BeanUtils.copyProperties (app, appsVo);
		result.success (appsVo);
		return result;
	}

	/**
	 * 查询普通栏目下的应用总数
	 *
	 * @param appColumn
	 * @return
	 */
	@Override
	public Result<Integer> qryCountByColumn (@PathVariable ("column") String appColumn)
	{
		if (StringUtils.isEmpty (appColumn))
		{
			return new Result<AppsVo> ().failure ("appColumnId illega params");
		}
		Result<Integer> result = new Result<> ();
		Integer total = appMapper.queryColumnAppRelationCount (appColumn);
		result.success (total);
		return result;
	}

	/**
	 * 根据appId删除应用
	 *
	 * @param appId
	 * @return
	 */
	@Override
	public Result delete (@PathVariable ("appId") String appId)
	{
		if (StringUtils.isEmpty (appId))
		{
			return new Result<AppsVo> ().failure ("appId illega params");
		}

		int flag = appMapper.delete (appId);

		if (0 < flag)
		{
			flag = appMapper.deleteAppLang (appId);
			if (0 < flag)
			{
				return new Result ().success ();
			}
			else
			{
				return new Result ().failure ("delete app failed.");
			}
		}
		else
		{
			return new Result ().failure ("delete app failed.");
		}
	}

	/**
	 * 更新app 下载次数
	 *
	 * @param appId
	 * @return
	 */
	@Override
	public Result upgradeDownloadTimes (@PathVariable ("appId") String appId)
	{
		if (StringUtils.isEmpty (appId))
		{
			return new Result ().failure ("appId illega params");
		}

		Integer flag = appMapper.modifyDownloadTimes (appId);

		if (0 < flag)
		{
			return new Result ().success ();
		}
		else
		{
			return new Result ().failure ("update app downtimes failed.");
		}
	}

	/**
	 * 猜你喜欢，推荐对应的游戏信息
	 *
	 * @param queryAppRequest
	 * @return
	 */
	@Override
	public Result<List<AppsVo>> guessAppRecommand (@RequestBody QueryAppRequest queryAppRequest)
	{
		Result<List<AppsVo>> result = new Result<> ();
		List<App> apps = null;
		if (StringUtils.isEmpty (queryAppRequest.getCatalogId ()))
		{
			//查询HOT下的游戏应用
			apps = appMapper.queryHotApp ("HOT", Language.getLanguage ());
		}
		else
		{
			//查询HOT下的游戏应用
			apps = appMapper.queryRecommandApp (queryAppRequest.getAppId (), queryAppRequest.getCatalogId (),
					Language.getLanguage ());
		}

		List<AppsVo> appsVos = Lists.newArrayList ();
		if (! CollectionUtils.isEmpty (apps))
		{
			apps.forEach (app -> {
				AppsVo appsVo = new AppsVo ();
				BeanUtils.copyProperties (app, appsVo);
				appsVos.add (appsVo);
			});
			result.setData (appsVos);
		}
		return result;
	}

	/**
	 * 批量修改应用状态
	 * 供平台使用
	 *
	 * @param batchModifyAppStatusRequest
	 * @return
	 */
	@Override
	public Result batchModifyAppStatus (@RequestBody BatchModifyAppStatusRequest batchModifyAppStatusRequest)
	{
		i ("APP", "batchModifyAppStatus", LOG_TYPE_REQUEST, batchModifyAppStatusRequest);
		if (null == batchModifyAppStatusRequest)
		{
			return new Result ().failure ("batchModifyAppStatus illegal params");
		}

		if (CollectionUtils.isEmpty (batchModifyAppStatusRequest.getAppModels ()))
		{
			return new Result ().failure ("AppModels is null");
		}

		//成功列表
		List<String> successList = Lists.newArrayList ();
		//失败列表
		List<String> faildList = Lists.newArrayList ();
		Map<String, Object> params = Maps.newHashMap ();
		//删除配置表信息
		List<String> targetIds = Lists.newArrayList ();
		for (AppModel appModel : batchModifyAppStatusRequest.getAppModels ())
		{
			params.clear ();
			targetIds.clear ();
			if (StringUtils.isEmpty (appModel.getAppId ()) || StringUtils.isEmpty (appModel.getStatus ()))
			{
				continue;
			}
			params.put ("appId", appModel.getAppId ());
			params.put ("appStatus", appModel.getStatus ());
			params.put ("appRate", appModel.getAppRate ());

			//应用下线，删除配置关系
			if ("2".equals (appModel.getStatus ()))
			{
				targetIds.add (appModel.getAppId ());
			}

			int flag = appMapper.modifyAppStatus (params);
			if (0 < flag)
			{
				successList.add (appModel.getAppId ());
			}
			else
			{
				faildList.add (appModel.getAppId ());
			}
		}
		if(!CollectionUtils.isEmpty (targetIds))
		{
			//删除配置关系
			catalogRelationMapper.removeRelation (targetIds);
		}

		//定义返回结果集合
		Result<BatchModifyAppStatusResponse> result = new Result<BatchModifyAppStatusResponse> ();
		BatchModifyAppStatusResponse batchModifyAppStatusResponse = new BatchModifyAppStatusResponse ();
		batchModifyAppStatusResponse.setFaildList (faildList);
		batchModifyAppStatusResponse.setSuccessList (successList);
		result.setData (batchModifyAppStatusResponse);

		i ("APP", "batchModifyAppStatus", LOG_TYPE_RESPONSE, result);
		return result;
	}
}
