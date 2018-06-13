/**
 * 文 件 名:  Meta
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/23 0023
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.common.domain;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/23 0023
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Meta implements Serializable
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
	 * No-Argument
	 */
	public Meta ()
	{

	}

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
