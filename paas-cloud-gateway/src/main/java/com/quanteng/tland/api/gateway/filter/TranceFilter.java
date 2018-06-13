/**
 * 文 件 名:  TranceFilter
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/10 0010
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.api.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.quanten.core.utils.Coder;
import com.quanteng.tland.api.gateway.configuration.AppKeyConfiguration;
import com.quanteng.tland.api.gateway.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

import static com.quanteng.tland.api.gateway.domain.Cons.*;
import static com.quanteng.tland.api.gateway.domain.Cons.ResultCode.REQUEST_INVALID;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * <网关过滤器>
 *
 * @author zping
 * @version 2018/4/10 0010
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class TranceFilter extends ZuulFilter
{

	/**
	 * 日志器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (TranceFilter.class);

	/**
	 * App Key 密钥
	 */
	@Autowired
	private AppKeyConfiguration appKeyConfiguration;

	/**
	 * 过滤器类型
	 * - pre
	 * - post
	 * - error
	 * - route
	 * ...
	 *
	 * @return
	 */
	@Override
	public String filterType ()
	{
		return PRE_TYPE;
	}

	/**
	 * 过滤器顺序
	 *
	 * @return
	 */
	@Override
	public int filterOrder ()
	{
		return FORM_BODY_WRAPPER_FILTER_ORDER - 1;
	}

	/**
	 * 可以自定义业务逻辑校验该过滤器是否需要执行
	 *
	 * @return
	 */
	@Override
	public boolean shouldFilter ()
	{
		return true;
	}

	/**
	 * 过滤器自定义业务  X_REQUEST_ID
	 *
	 * @return
	 * @throws ZuulException
	 */
	@Override
	public Object run () throws ZuulException
	{
		RequestContext ctx = RequestContext.getCurrentContext ();
		HttpServletRequest request = ctx.getRequest ();

		//获取参数签名
		String sign = request.getHeader (X_WSSA);

		//获取时间戳
		String timestamp = request.getHeader (X_TIME_STAMP);

		if (StringUtils.isEmpty (sign) || StringUtils.isEmpty (timestamp))
		{
			LOGGER.warn ("sign is empty.");
			ctx.setResponseStatusCode (HttpServletResponse.SC_UNAUTHORIZED);
			ctx.setSendZuulResponse (false);
			ctx.setResponseBody (JSONObject.toJSONString (Result.failed (REQUEST_INVALID, "Request Invalid.")));
			return ctx;
		}

		if (StringUtils.isEmpty (request.getHeader (X_REQUEST_ID)))
		{
			LOGGER.warn ("X-Request-ID is empty.");
			ctx.setResponseStatusCode (HttpServletResponse.SC_UNAUTHORIZED);
			ctx.setSendZuulResponse (false);
			ctx.setResponseBody (JSONObject.toJSONString (Result.failed (REQUEST_INVALID, "Request Invalid.")));
			return ctx;
		}

		//参数签名校验
		if (! Objects.equals (sign, sign (appKeyConfiguration.getKeys ().get (APP_KEY_SECRET_KEY), timestamp)))
		{
			LOGGER.warn ("Request params Invalid.");
			ctx.setResponseStatusCode (HttpServletResponse.SC_UNAUTHORIZED);
			ctx.setSendZuulResponse (false);
			ctx.setResponseBody (JSONObject.toJSONString (Result.failed (REQUEST_INVALID, "Request Invalid.")));
			return ctx;
		}

		//接口请求两分钟有效
		if ((System.currentTimeMillis () - Long.valueOf (timestamp)) > 2 * 60 * 1000)
		{
			LOGGER.warn ("Request is Invalid.");
			ctx.setResponseStatusCode (HttpServletResponse.SC_UNAUTHORIZED);
			ctx.setSendZuulResponse (false);
			ctx.setResponseBody (JSONObject.toJSONString (Result.failed (REQUEST_INVALID, "Request Invalid.")));
			return ctx;
		}

		ctx.addZuulRequestHeader (X_TRANCE_ID, request.getHeader (X_REQUEST_ID));
		return ctx;
	}

	/**
	 * 参数签名
	 *
	 * @param secretKey
	 * @param timestamp
	 * @return
	 */
	private static String sign (String secretKey, String timestamp)
	{
		String sign = null;
		try
		{
			sign = Coder.encryptBASE64 (Coder.encryptMD5 ((secretKey + timestamp + secretKey).getBytes ()));
		}
		catch (Exception e)
		{
			LOGGER.error ("Request is Invalid.", e);
		}
		return sign.trim ();
	}
}
