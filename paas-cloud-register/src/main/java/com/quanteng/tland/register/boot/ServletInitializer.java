package com.quanteng.tland.register.boot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Servlet初始化配置
 */
public class ServletInitializer extends SpringBootServletInitializer
{

	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder application)
	{
		return application.sources (ServiceCenterApplication.class);
	}

}
