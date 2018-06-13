/**
 * 文 件 名:  Constants
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/20 0020
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.common.cons;

/**
 * <常量定义>
 *
 * @author zping
 * @version 2018/3/20 0020
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Constants
{
	/**
	 * 媒体类型
	 */
	public interface MediaType
	{
		public static final String ENCODE_UTF8 = "UTF-8";
		public static final String APPLICATION_JSON_UTF8 = "application/json; charset=UTF-8";
	}

	/**
	 * 错误码
	 */
	public interface ResultCode
	{
		public static final String NOT_LOGIN = "999998";
		public static final String FAILED = "-1";
		public static final String SUCCESS = "0";
	}

	/**
	 * 自定义常量
	 */
	public interface Cons
	{
		/**
		 * 日志追踪ID
		 */
		public static final String TRANCE_ID = "tranceID";
		/**
		 * 接口请求头ID
		 */
		public static final String X_TRANCE_ID = "X-Trance-Id";
		/**
		 * 机器名称
		 */
		public static final String MACHINE_NAME = "machine";
		/**
		 * 语言选项
		 */
		public static final String LOCAL_LANG_ID = "X-Language-Id";
		/**
		 * 默认语言选项
		 */
		public static final String DEFAULT_LOCAL = "en_US";
		/**
		 * 数据分页开始KEY
		 */
		public static final String DATA_PAGE_START = "start";
		/**
		 * 数据分页结束KEY
		 */
		public static final String DATA_PAGE_SIZE = "size";
		/**
		 * 数据查询多语言KEY
		 */
		public static final String DATA_LOCAL_LANGUAGE = "language";
	}

	/**
	 * REDIS中的存储KEY
	 */
	public interface RedisKeyCons
	{
		/**
		 * 用户验证码前缀
		 */
		public static final String MOBILE_VCODE_PREFIX = "vc_";
	}
}
