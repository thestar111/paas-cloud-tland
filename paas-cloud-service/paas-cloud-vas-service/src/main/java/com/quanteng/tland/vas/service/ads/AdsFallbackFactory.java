/**
 * 文 件 名:  UserFallbackFactory
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/9 0009
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.service.ads;

import com.quanteng.tland.cms.pojo.ad.domain.AdsVo;
import com.quanteng.tland.cms.pojo.ad.request.AddAdsRequest;
import com.quanteng.tland.cms.pojo.ad.request.QueryAdListRequest;
import com.quanteng.tland.cms.pojo.ad.request.UpdateAdsRequest;
import com.quanteng.tland.common.domain.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <用户服务熔断降级>
 *
 * @author zping
 * @version 2018/4/9 0009
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class AdsFallbackFactory implements FallbackFactory<AdService>
{

	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (AdsFallbackFactory.class);

	@Override
	public AdService create (Throwable throwable)
	{

		LOGGER.error (String.format ("ads Service Not Avialable : %s", throwable.getMessage ()));
		return new AdService ()
		{
			/**
			 * 添加广告信息
			 *
			 * @param addAdsRequest
			 * @return
			 */
			@Override
			public Result add (AddAdsRequest addAdsRequest)
			{
				return new Result ().failure ("Ads Service not avialiable");
			}

			/**
			 * 广告信息修改
			 *
			 * @param updateAdsRequest
			 * @return
			 */
			@Override
			public Result update (UpdateAdsRequest updateAdsRequest)
			{
				return new Result ().failure ("Ads Service not avialiable");
			}

			/**
			 * 根据广告ID查询 供平台使用
			 *
			 * @param adId
			 * @return
			 */
			@Override
			public Result<AdsVo> queryAdById (String adId)
			{
				return new Result ().failure ("Ads Service not avialiable");
			}

			/**
			 * 根据广告ID查询 供客户端使用
			 *
			 * @param adId
			 * @return
			 */
			@Override
			public Result<AdsVo> findAdById (String adId)
			{
				return new Result ().failure ("Ads Service not avialiable");
			}

			/**
			 * 根据广告名称查询
			 *
			 * @param queryAdListRequest
			 * @return
			 */
			@Override
			public Result<List<AdsVo>> queryAdList (QueryAdListRequest queryAdListRequest)
			{
				return new Result ().failure ("Cms Service not avialiable");
			}

			/**
			 * 根据广告id删除
			 *
			 * @param adId
			 * @return
			 */
			@Override
			public Result delete (String adId)
			{
				return new Result ().failure ("Ads Service not avialiable");
			}

			/**
			 * 查询客户端启动页广告信息
			 * @return
			 */
			@Override
			public Result<AdsVo> queryLanuchAd ()
			{
				return new Result ().failure ("Ads Service not avialiable");
			}
		};
	}
}
