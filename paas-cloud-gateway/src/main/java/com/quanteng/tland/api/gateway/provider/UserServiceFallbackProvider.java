/**
 * 文 件 名:  UserServiceFallbackProvider
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/8 0008
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.api.gateway.provider;

import com.alibaba.fastjson.JSONObject;
import com.quanteng.tland.api.gateway.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.quanteng.tland.api.gateway.domain.Cons.ResultCode.SERVICE_NOT_AVALIABLE;

/**
 * <接口网关服务降级回退>
 *
 * @author zping
 * @version 2018/4/8 0008
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class UserServiceFallbackProvider implements FallbackProvider
{

	private static final Logger LOGGER = LoggerFactory.getLogger (UserServiceFallbackProvider.class);

	/**
	 * 表明是哪个服务熔断
	 * 标识服务名称 : 服务编号
	 * 拦截所有服务 : *
	 *
	 * @return
	 */
	@Override
	public String getRoute ()
	{
		return "*";
	}

	/**
	 * 状态码返回
	 *
	 * @param route
	 * @param cause
	 * @return
	 */
	@Override
	public ClientHttpResponse fallbackResponse (String route, Throwable cause)
	{
		return new ClientHttpResponse ()
		{
			/**
			 * 熔断时返回码
			 * @return
			 * @throws IOException
			 */
			@Override
			public HttpStatus getStatusCode () throws IOException
			{
				return HttpStatus.OK;
			}

			/**
			 * 数字类型的状态码
			 * @return
			 * @throws IOException
			 */
			@Override
			public int getRawStatusCode () throws IOException
			{
				return this.getStatusCode ().value ();
			}

			/**
			 * 状态文本，本例返回的其实就是OK
			 * @return
			 * @throws IOException
			 */
			@Override
			public String getStatusText () throws IOException
			{
				return this.getStatusCode ().getReasonPhrase ();
			}

			@Override
			public void close ()
			{

			}

			/**
			 * 返回响应报文
			 * @return
			 * @throws IOException
			 */
			@Override
			public InputStream getBody () throws IOException
			{
				Result result = new Result ();
				result.setResultCode (SERVICE_NOT_AVALIABLE);
				result.setResultMessage ("{" + route + "} 服务不可用，请稍后再试");
				return new ByteArrayInputStream (JSONObject.toJSONString (result).getBytes ());
			}

			/**
			 * 设置响应头
			 * @return
			 */
			@Override
			public HttpHeaders getHeaders ()
			{
				HttpHeaders headers = new HttpHeaders ();
				headers.setContentType (MediaType.APPLICATION_JSON);
				return headers;
			}
		};
	}
}
