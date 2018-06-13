/**
 * 文 件 名:  AppFallbackFactory
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/14
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.service.app;

import com.quanteng.tland.cms.pojo.app.domain.AppsVo;
import com.quanteng.tland.cms.pojo.app.request.AddAppRequest;
import com.quanteng.tland.cms.pojo.app.request.BatchModifyAppStatusRequest;
import com.quanteng.tland.cms.pojo.app.request.ModifyAppRequest;
import com.quanteng.tland.cms.pojo.app.request.QueryAppRequest;
import com.quanteng.tland.cms.pojo.app.response.BatchModifyAppStatusResponse;
import com.quanteng.tland.common.domain.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <用户服务熔断降级>
 *
 * @author LJun
 * @version 2018/5/14
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class AppFallbackFactory implements FallbackFactory<AppService>
{
	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (AppFallbackFactory.class);

	@Override
	public AppService create (Throwable throwable)
	{
		LOGGER.error (String.format ("Cms Service Not Avialable : %s", throwable.getMessage ()));

		return new AppService ()
		{
			/**
			 * 添加游戏
			 *
			 * @param addAppRequest
			 * @return
			 */
			@Override
			public Result add (AddAppRequest addAppRequest)
			{
				return null;
			}

			/**
			 * 更新游戏
			 *
			 * @param modifyAppRequest
			 * @return
			 */
			@Override
			public Result modify (ModifyAppRequest modifyAppRequest)
			{
				return null;
			}

			/**
			 * 多条件查询
			 *
			 * @param queryAppRequest
			 * @return
			 */
			@Override
			public Result<List<AppsVo>> queryList (QueryAppRequest queryAppRequest)
			{
				return null;
			}

			/**
			 * 根据营销分类编号查询
			 *
			 * @param catalogId
			 * @param start
			 * @param size
			 * @return
			 */
			@Override
			public Result<List<AppsVo>> queryByPromotionCatalogId (String catalogId, Integer start, Integer size)
			{
				return null;
			}

			/**
			 * 根据游戏普通分类，状态查询
			 *
			 * @param catalogId
			 * @param start
			 * @param size
			 * @return
			 */
			@Override
			public Result<List<AppsVo>> queryAppByNormalCatalog (String catalogId, Integer start, Integer size)
			{
				return null;
			}

			/**
			 * 根据ID查询应用 供平台使用
			 *
			 * @param appId
			 * @return
			 */
			@Override
			public Result<AppsVo> queryAppById (String appId)
			{
				return null;
			}

			/**
			 * 根据ID查询应用  供客户端使用
			 *
			 * @param appId
			 * @return
			 */
			@Override
			public Result<AppsVo> findAppById (String appId)
			{
				return null;
			}

			/**
			 * 根据appId删除应用
			 *
			 * @param appId
			 * @return
			 */
			@Override
			public Result delete (String appId)
			{
				return null;
			}

			/**
			 * 查询普通栏目下的应用总数
			 *
			 * @param appColumn
			 * @return
			 */
			@Override
			public Result<Integer> qryCountByColumn (String appColumn)
			{
				return null;
			}

			/**
			 * 更新app 下载次数
			 *
			 * @param appId
			 * @return
			 */
			@Override
			public Result upgradeDownloadTimes (String appId)
			{
				return null;
			}

			/**
			 * 猜你喜欢，推荐对应的游戏信息
			 * @param queryAppRequest
			 * @return
			 */
			@Override
			public Result<List<AppsVo>> guessAppRecommand (QueryAppRequest queryAppRequest)
			{
				return null;
			}

			/**
			 * 批量修改应用状态
			 * 供平台使用
			 *
			 * @param batchModifyAppStatusRequest
			 * @return
			 */
			@Override
			public Result<BatchModifyAppStatusResponse> batchModifyAppStatus (
					BatchModifyAppStatusRequest batchModifyAppStatusRequest)
			{
				return null;
			}
		};
	}
}
