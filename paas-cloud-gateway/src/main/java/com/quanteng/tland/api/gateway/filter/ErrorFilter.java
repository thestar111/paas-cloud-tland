/**
 * 文 件 名:  ErrorFilter
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/16 0016
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ERROR_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_ERROR_FILTER_ORDER;

/**
 * <异常统一处理过滤器>
 *
 * @author zping
 * @version 2018/4/16 0016
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class ErrorFilter extends ZuulFilter
{
	/**
	 * 日志器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (ErrorFilter.class);

	@Override
	public String filterType ()
	{
		return ERROR_TYPE;
	}

	@Override
	public int filterOrder ()
	{
		return SEND_ERROR_FILTER_ORDER + 10;
	}

	@Override
	public boolean shouldFilter ()
	{
		return true;
	}

	@Override
	public Object run () throws ZuulException
	{
		RequestContext ctx = RequestContext.getCurrentContext ();
		Throwable throwable = ctx.getThrowable ();
		LOGGER.error ("This is a ErrorFilter : {}", throwable.getCause ().getMessage ());
		ctx.set ("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		ctx.set ("error.exception", throwable.getCause ());
		return ctx;
	}
}
