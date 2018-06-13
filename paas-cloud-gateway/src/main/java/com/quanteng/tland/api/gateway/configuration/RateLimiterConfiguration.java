/**
 * 文 件 名:  RateLimiterConfiguration
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/9 0009
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.api.gateway.configuration;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.DefaultRateLimiterErrorHandler;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.RateLimiterErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/9 0009
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
public class RateLimiterConfiguration
{

	private static final Logger LOGGER = LoggerFactory.getLogger (RateLimiterConfiguration.class);

	@Bean
	public RateLimiterErrorHandler rateLimitErrorHandler ()
	{
		return new DefaultRateLimiterErrorHandler ()
		{
			@Override
			public void handleSaveError (String key, Exception e)
			{
				LOGGER.error ("Route RateLimit Handle Save Exception : ", e);
			}

			@Override
			public void handleFetchError (String key, Exception e)
			{
				LOGGER.error (String.format ("Route RateLimit Handle Route{%s} Exception : ", key), e);
			}

			@Override
			public void handleError (String msg, Exception e)
			{
				LOGGER.error (String.format ("Route RateLimit Handle Exception : {%s}", msg), e);
			}
		};
	}
}
