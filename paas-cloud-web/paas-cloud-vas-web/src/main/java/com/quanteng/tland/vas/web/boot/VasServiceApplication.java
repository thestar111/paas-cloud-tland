package com.quanteng.tland.vas.web.boot;

import com.quanteng.tland.vas.web.config.VasServiceConfiguration;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 添加配置Jersey启动类
 *
 * @return
 */
@EnableEurekaClient
@EnableFeignClients (basePackages = "com.quanteng.tland.vas.service")
@SpringBootApplication (exclude = { DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class, JdbcTemplateAutoConfiguration.class })
@ComponentScan (basePackages = "com.quanteng.tland.vas")
@EnableHystrix
@ServletComponentScan ("com.quanteng.tland.vas.web.filter")
public class VasServiceApplication
{
	@Bean
	public ServletRegistrationBean servletRegistrationBean ()
	{
		ServletRegistrationBean registrationBean = new ServletRegistrationBean (new ServletContainer (), "/vas/*");
		registrationBean
				.addInitParameter (ServletProperties.JAXRS_APPLICATION_CLASS, VasServiceConfiguration.class.getName ());
		return registrationBean;
	}

	public static void main (String[] args)
	{
		SpringApplication.run (VasServiceApplication.class, args);
	}
}
