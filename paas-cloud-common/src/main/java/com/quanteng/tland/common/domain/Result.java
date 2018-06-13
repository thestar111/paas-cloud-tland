/**
 * 文 件 名:  Result
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.common.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import static com.quanteng.tland.common.cons.Constants.ResultCode.FAILED;
import static com.quanteng.tland.common.cons.Constants.ResultCode.SUCCESS;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
@NoArgsConstructor
public class Result<T> implements Serializable
{
	/**
	 * 成功
	 */
	private static final String OK = "ok";

	/**
	 * 失败
	 */
	private static final String ERROR = "error";

	/**
	 * 返回结果码
	 */
	private String resultCode = "0";

	/**
	 * 返回结果消息
	 */

	private String resultMessage = "success";
	/**
	 * 返回元数据信息
	 */
	private Meta meta;

	/**
	 * 返回具体对象信息
	 */
	private T data;
	/**
	 * 返回数据分页时，有效
	 */
	private int totalCount = 0;

	/**
	 * 成功
	 *
	 * @return
	 */
	public Result success ()
	{
		this.meta = new Result.Meta (true, OK);
		this.setResultCode (SUCCESS);
		return this;
	}

	/**
	 * 成功
	 *
	 * @param data
	 * @return
	 */
	public Result success (T data)
	{
		this.meta = new Result.Meta (true, OK);
		this.data = data;
		this.setResultCode (SUCCESS);
		return this;
	}

	/**
	 * 失败
	 *
	 * @return
	 */
	public Result failure ()
	{
		this.meta = new Result.Meta (false, ERROR);
		this.setResultCode (FAILED);
		return this;
	}

	/**
	 * 失败
	 *
	 * @param message
	 * @return
	 */
	public Result failure (String message)
	{
		this.meta = new Result.Meta (false, message);
		this.setResultCode (FAILED);
		this.setResultMessage (message);
		return this;
	}

	/**
	 * 元数据
	 *
	 * @return
	 */
	public Result.Meta getMeta ()
	{
		return meta;
	}

	/**
	 * 元数据
	 *
	 * @return
	 */
	public T getData ()
	{
		return data;
	}

	/**
	 * 设置返回数据
	 *
	 * @param data
	 */
	public void setData (T data)
	{
		this.data = data;
	}

	/**
	 * 元数据信息
	 */
	@Getter
	@Setter
	@NoArgsConstructor
	public class Meta
	{
		/**
		 * 是否成功
		 */
		private boolean success;

		/**
		 * 描述信息
		 */
		private String message;

		/**
		 * 设置元数据
		 *
		 * @param success
		 */
		public Meta (boolean success)
		{
			this.success = success;
		}

		/**
		 * 设置元数据
		 *
		 * @param success
		 * @param message
		 */
		public Meta (boolean success, String message)
		{
			this.success = success;
			this.message = message;
		}

		/**
		 * 是否成功
		 *
		 * @return
		 */
		public boolean isSuccess ()
		{
			return success;
		}

		/**
		 * 描述信息
		 *
		 * @return
		 */
		public String getMessage ()
		{
			return message;
		}

		@Override
		public String toString ()
		{
			final StringBuilder sb = new StringBuilder ("Meta{");
			sb.append ("success=").append (success);
			sb.append (", message='").append (message).append ('\'');
			sb.append ('}');
			return sb.toString ();
		}
	}

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("Result{");
		sb.append ("resultCode='").append (resultCode).append ('\'');
		sb.append (", resultMessage='").append (resultMessage).append ('\'');
		sb.append (", meta=").append (meta);
		sb.append (", data=").append (data);
		sb.append ('}');
		return sb.toString ();
	}
}
