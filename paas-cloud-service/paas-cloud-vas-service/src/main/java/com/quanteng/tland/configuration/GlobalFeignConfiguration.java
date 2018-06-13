/**
 * 文 件 名:  UserFeignConfiguration
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static com.quanteng.tland.common.cons.Constants.Cons.LOCAL_LANG_ID;
import static com.quanteng.tland.common.cons.Constants.Cons.X_TRANCE_ID;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
public class GlobalFeignConfiguration implements RequestInterceptor
{

	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (GlobalFeignConfiguration.class);

	@Override
	public void apply (RequestTemplate requestTemplate)
	{
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes ();
		String tranceID = (String) requestAttributes.getRequest ().getAttribute (X_TRANCE_ID);
		String language = (String) requestAttributes.getRequest ().getAttribute (LOCAL_LANG_ID);
		//发送日志链
		requestTemplate.header (X_TRANCE_ID, tranceID);
		requestTemplate.header (LOCAL_LANG_ID, language);
	}
}
