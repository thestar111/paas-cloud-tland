/**
 * 文 件 名:  Order
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/26 0026
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.user.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/5/26 0026
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class Order implements Serializable
{
	/**
	 * 用户账号
	 */
	private String accountId;
	/**
	 * 套餐编号
	 */
	private String packageId;
	/**
	 * 生效时间
	 */
	private String startTime;
	/**
	 * 过期时间
	 */
	private String endTime;
	/**
	 * 订单状态
	 */
	private String status;
	/**
	 * 订购渠道
	 */
	private String channel;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("Order{");
		sb.append ("accountId='").append (accountId).append ('\'');
		sb.append (", packageId='").append (packageId).append ('\'');
		sb.append (", startTime='").append (startTime).append ('\'');
		sb.append (", endTime='").append (endTime).append ('\'');
		sb.append (", status='").append (status).append ('\'');
		sb.append (", channel='").append (channel).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
