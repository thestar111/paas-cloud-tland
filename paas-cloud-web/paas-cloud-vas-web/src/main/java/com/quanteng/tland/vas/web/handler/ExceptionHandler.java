/**
 * 文 件 名:  ExceptionHandler
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.web.handler;

import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.common.exception.VasException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * <异常统一处理>
 *
 * @author zping
 * @version 2018/3/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Exception>
{

	/**
	 * 日志管理器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (ExceptionHandler.class);

	/**
	 * 构造返回对象
	 *
	 * @param exception
	 * @return
	 */
	@Override
	public Response toResponse (Exception exception)
	{
		Result result = new Result ().failure ();
		if (exception instanceof VasException)
		{
			LOGGER.error (String.format ("ExceptionHandler handler exception : %s",
					((VasException) exception).getLocalizedMessage ()));
			result.setResultCode (((VasException) exception).getResultCode ());
			result.setResultMessage (((VasException) exception).getResultMessage ());
		}
		else
		{
			LOGGER.error ("ExceptionHandler handler exception : ", exception.getLocalizedMessage ());
			result.setResultCode ("99999999");
			result.setResultMessage ("Other Error.");
		}
		return Response.status (Response.Status.INTERNAL_SERVER_ERROR).entity (result).build ();
	}
}
