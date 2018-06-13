package com.quanteng.tland.charging.web.boot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Servlet 初始化启动类
 *
 * @author zping
 * @see 2018-04-05
 */
public class ServletInitializer extends SpringBootServletInitializer
{

	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder application)
	{
		return application.sources (ChargingServiceApplication.class);
	}
}
