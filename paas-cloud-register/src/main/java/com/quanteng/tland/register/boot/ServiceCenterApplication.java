package com.quanteng.tland.register.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 游戏服务注册中心
 *
 * @author zping
 * @see 2018-04-05
 */
@SpringBootApplication (exclude = { JpaRepositoriesAutoConfiguration.class, JdbcTemplateAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class })
@EnableEurekaServer
public class ServiceCenterApplication
{
	public static void main (String[] args)
	{
		SpringApplication.run (ServiceCenterApplication.class, args);
	}
}
