/**
 * 文 件 名:  LocalFilter
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/27 0027
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.web.filter;

import com.quanteng.tland.common.thread.Language;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.quanteng.tland.common.cons.Constants.Cons.DEFAULT_LOCAL;
import static com.quanteng.tland.common.cons.Constants.Cons.LOCAL_LANG_ID;

/**
 * <多语言信息过滤器>
 *
 * @author zping
 * @version 2018/4/27 0027
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@WebFilter (filterName = "localFilter", urlPatterns = "/vas/*")
public class LocalFilter implements Filter
{

	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (LocalFilter.class);

	@Override
	public void init (FilterConfig filterConfig) throws ServletException
	{
		LOGGER.debug ("init local filter ... ");
	}

	@Override
	public void doFilter (ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String local = request.getHeader (LOCAL_LANG_ID);
		if (StringUtils.isEmpty (local))
		{
			local = DEFAULT_LOCAL;
		}
		Language.setLanguage (local);
		filterChain.doFilter (request, servletResponse);
	}

	@Override
	public void destroy ()
	{
		LOGGER.debug ("destroy local filter ... ");
	}
}
