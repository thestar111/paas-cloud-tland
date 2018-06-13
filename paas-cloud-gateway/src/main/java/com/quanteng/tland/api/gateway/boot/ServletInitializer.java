package com.quanteng.tland.api.gateway.boot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <初始化Servlet容器>
 *
 * @author zping
 * @version V1.0.0
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ServletInitializer extends SpringBootServletInitializer
{

	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder application)
	{
		return application.sources (TlandApiGatewayApplication.class);
	}

}
