package com.quanteng.tland.api.gateway.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * <游戏运营服务网关配置>
 *
 * @author zping
 * @version 2018/4/8 0008
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@EnableZuulProxy
@EnableEurekaClient
@EnableHystrixDashboard
@ComponentScan ("com.quanteng.tland.api.gateway")
@SpringBootApplication (exclude = { JdbcTemplateAutoConfiguration.class, DataSourceAutoConfiguration.class,
		JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class TlandApiGatewayApplication
{

	public static void main (String[] args)
	{
		SpringApplication.run (TlandApiGatewayApplication.class, args);
	}
}
