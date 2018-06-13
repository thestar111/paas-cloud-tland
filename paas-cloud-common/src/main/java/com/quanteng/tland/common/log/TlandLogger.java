/**
 * 文 件 名:  TlandLogger
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/2 0002
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.common.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <日志记录管理>
 *
 * @author zping
 * @version 2018/5/2 0002
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TlandLogger
{

	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LogManager.getLogger (TlandLogger.class);

	/**
	 * 请求类型
	 */
	public static final String LOG_TYPE_REQUEST = "request";

	/**
	 * 响应类型
	 */
	public static final String LOG_TYPE_RESPONSE = "response";

	/**
	 * 日志DEBUG信息
	 *
	 * @param moduleName 模块名称
	 * @param method     方法名称
	 * @param type       日志类型
	 * @param messge     消息内容
	 */
	public static void d (String moduleName, String method, String type, Object messge)
	{
		LOGGER.debug ("{} invoke {} ====================> {} : {}", moduleName, method, type, messge);
	}

	/**
	 * 日志INFO信息
	 *
	 * @param moduleName 模块名称
	 * @param method     方法名称
	 * @param type       日志类型
	 * @param messge     消息内容
	 */
	public static void i (String moduleName, String method, String type, Object messge)
	{
		LOGGER.info ("{} invoke {} ====================> {} : {}", moduleName, method, type, messge);
	}

	/**
	 * 日志ERROR信息
	 *
	 * @param moduleName 模块名称e
	 * @param method     方法名称
	 * @param messge     消息内容
	 */
	public static void e (String moduleName, String method, Object messge)
	{
		LOGGER.error ("{} invoke {} ====================> exception : {}", moduleName, method, messge);
	}
}
