/**
 * 文 件 名:  UserCenterConfiguration
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/8 0008
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.web.config;

import com.quanteng.tland.common.annotation.Api;
import com.quanteng.tland.vas.web.handler.ExceptionHandler;
import com.quanteng.tland.vas.web.handler.GzipInterceptor;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.process.internal.RequestContext;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/8 0008
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class VasServiceConfiguration extends ResourceConfig
{
	/**
	 * 资源实现接口
	 */
	private static final String RESOURCE_BASE_PACKAGE = "com.quanteng.tland.vas.provider";

	public VasServiceConfiguration ()
	{
		register (RequestContext.class);
		register (JacksonFeature.class);
		register (GzipInterceptor.class);
		register (ExceptionHandler.class);

		ClassPathScanningCandidateComponentProvider scan = new ClassPathScanningCandidateComponentProvider (false);

		scan.addIncludeFilter (new AnnotationTypeFilter (Api.class));
		scan.addIncludeFilter (new AnnotationTypeFilter (Provider.class));

		//将带有Path，Provider注解加入到资源中
		registerClasses (scan.findCandidateComponents (RESOURCE_BASE_PACKAGE).stream ()
				.map (beanDefinition -> ClassUtils
						.resolveClassName (beanDefinition.getBeanClassName (), this.getClassLoader ()))
				.collect (Collectors.toSet ()));

	}
}
