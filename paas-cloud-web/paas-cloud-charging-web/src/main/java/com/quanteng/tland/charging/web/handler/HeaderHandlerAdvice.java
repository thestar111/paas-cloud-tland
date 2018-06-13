/**
 * 文 件 名:  HeaderHandlerAdvice
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/12/29 0029
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.charging.web.handler;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * <系统响应头处理通知>
 *
 * @author zping
 * @version 2017/12/29 0029
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@ControllerAdvice
public class HeaderHandlerAdvice implements ResponseBodyAdvice<Object>
{
	/**
	 * Whether this component supports the given controller method return type
	 * and the selected {@code HttpMessageConverter} type.
	 *
	 * @param returnType    the return type
	 * @param converterType the selected converter type
	 * @return {@code true} if {@link #beforeBodyWrite} should be invoked;
	 * {@code false} otherwise
	 */
	@Override
	public boolean supports (MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType)
	{
		return true;
	}

	/**
	 * Invoked after an {@code HttpMessageConverter} is selected and just before
	 * its write method is invoked.
	 *
	 * @param body                  the body to be written
	 * @param returnType            the return type of the controller method
	 * @param selectedContentType   the content type selected through content negotiation
	 * @param selectedConverterType the converter type selected to write to the response
	 * @param request               the current request
	 * @param response              the current response
	 * @return the body that was passed in or a modified (possibly new) instance
	 */
	@Override
	public Object beforeBodyWrite (Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response)
	{
		//esponse.getHeaders ().add ("traceID", UUID.randomUUID ().toString ().replace ("-", ""));
		return body;
	}
}
