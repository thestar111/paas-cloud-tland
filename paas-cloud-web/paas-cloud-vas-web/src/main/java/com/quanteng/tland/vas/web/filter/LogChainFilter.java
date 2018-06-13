/**
 * 文 件 名:  LogChainFilter
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.web.filter;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.quanteng.tland.common.cons.Constants.Cons.TRANCE_ID;
import static com.quanteng.tland.common.cons.Constants.Cons.X_TRANCE_ID;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@WebFilter (urlPatterns = "/vas/*", filterName = "LogFilterChain")
public class LogChainFilter implements Filter
{

	private static final Logger LOGGER = LoggerFactory.getLogger (LogChainFilter.class);

	@Override
	public void init (FilterConfig filterConfig) throws ServletException
	{
		LOGGER.debug ("Logger Chain init ...");
	}

	@Override
	public void doFilter (ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String traceID = request.getHeader (X_TRANCE_ID);
		ThreadContext.put (TRANCE_ID, traceID);
		filterChain.doFilter (request, response);
		ThreadContext.clearAll ();
	}

	@Override
	public void destroy ()
	{
		LOGGER.debug ("Logger Chain destroy ...");
	}
}
