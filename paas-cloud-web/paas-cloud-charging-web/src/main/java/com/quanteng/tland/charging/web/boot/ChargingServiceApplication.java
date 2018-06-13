package com.quanteng.tland.charging.web.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 添加配置Jersey启动类
 *
 * @return
 */
@EnableEurekaClient
@SpringBootApplication
@ComponentScan ("com.quanteng.tland.charging")
public class ChargingServiceApplication
{

	public static void main (String[] args)
	{
		SpringApplication.run (ChargingServiceApplication.class, args);
	}
}
