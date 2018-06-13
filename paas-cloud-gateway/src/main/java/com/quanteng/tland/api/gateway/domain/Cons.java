/**
 * 文 件 名:  Cons
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/10 0010
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.api.gateway.domain;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/10 0010
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Cons
{
	/**
	 * 请求ID
	 */
	public static final String X_REQUEST_ID = "X-Request-ID";

	/**
	 * 日志链路编号
	 */
	public static final String X_TRANCE_ID = "X-Trance-Id";

	/**
	 * 请求头信息
	 */
	public static final String X_AUTHORIZATION = "X-Authorization";

	/**
	 * 请求时间戳
	 */
	public static final String X_TIME_STAMP = "timestamp";

	/**
	 * 请求签名
	 */
	public static final String X_WSSA = "X_WSSA";

	/**
	 * APP 密钥
	 */
	public static final String APP_KEY_SECRET_KEY = "secretKey";

	/**
	 * 错误码
	 */
	public interface ResultCode
	{
		/**
		 * 服务不可用
		 */
		public static final String SERVICE_NOT_AVALIABLE = "99999999";

		/**
		 * Token无效
		 */
		public static final String TOKEN_NOT_INVALID = "99999998";

		/**
		 * 请求非法，参数被篡改
		 */
		public static final String REQUEST_INVALID = "10000001";
	}
}
