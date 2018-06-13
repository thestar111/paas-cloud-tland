package com.quanteng.tland.user.web.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 添加配置Jersey启动类
 *
 * @return
 */
@EnableEurekaClient
@SpringBootApplication
@ComponentScan ("com.quanteng.tland.user")
@ServletComponentScan ("com.quanteng.tland.user.web.filter")
public class UserCenterApplication
{
	public static void main (String[] args)
	{
		SpringApplication.run (UserCenterApplication.class, args);
	}
}
