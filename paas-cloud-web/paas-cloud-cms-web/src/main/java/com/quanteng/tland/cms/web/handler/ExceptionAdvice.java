/**
 * 文 件 名:  ExceptionAdvice
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/12/27 0027
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.web.handler;

import com.quanteng.tland.common.domain.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <统一异常处理类>
 *
 * @author zping
 * @version 2017/12/27 0027
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice
{
	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus (HttpStatus.BAD_REQUEST)
	@ExceptionHandler (HttpMessageNotReadableException.class)
	public Result handleHttpMessageNotReadableException (HttpMessageNotReadableException e)
	{
		return new Result ().failure ("could_not_read_json");
	}

	/**
	 * 405 - Method Not Allowed
	 */
	@ResponseStatus (HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler (HttpRequestMethodNotSupportedException.class)
	public Result handleHttpRequestMethodNotSupportedException (HttpRequestMethodNotSupportedException e)
	{
		return new Result ().failure ("request_method_not_supported");
	}

	/**
	 * 415 - Unsupported Media Type
	 */
	@ResponseStatus (HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler (HttpMediaTypeNotSupportedException.class)
	public Result handleHttpMediaTypeNotSupportedException (Exception e)
	{
		return new Result ().failure ("content_type_not_supported");
	}

	/**
	 * 500 - Internal Server Error
	 */
	@ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler (Exception.class)
	public Result handleException (Exception e)
	{
		return new Result ().failure (e.getMessage ());
	}
}
