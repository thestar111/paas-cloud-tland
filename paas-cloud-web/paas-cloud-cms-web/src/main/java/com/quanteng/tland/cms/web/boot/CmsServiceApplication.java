package com.quanteng.tland.cms.web.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 *
 * @return
 */
@EnableEurekaClient
@SpringBootApplication
@ComponentScan (basePackages = "com.quanteng.tland.cms")
@ServletComponentScan (value = "com.quanteng.tland.cms.web.filter")
public class CmsServiceApplication
{
	public static void main (String[] args)
	{
		SpringApplication.run (CmsServiceApplication.class, args);
	}
}
