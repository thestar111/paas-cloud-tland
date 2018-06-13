/**
 * 文 件 名:  OrderVo
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/4 0004
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.charging.pojo.order.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <用户订购关系VO对象>
 *
 * @author zping
 * @version 2018/5/4 0004
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class OrderVo implements Serializable
{
	/**
	 * 订单编号
	 */
	private String subId;
	/**
	 * 用户账号
	 */
	private String accountId;
	/**
	 * 套餐编号
	 */
	private String packageId;
	/**
	 * 套餐类型
	 */
	private String packageType;
	/**
	 * 开始时间
	 */
	private String startTime;
	/**
	 * 结束时间
	 */
	private String endTime;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 原因
	 */
	private String reason;
	/**
	 * 退订渠道
	 */
	private String unSubChannel;
	/**
	 * 订购渠道
	 */
	private String channel;
	/**
	 * 模式
	 */
	private String model;
	/**
	 * 应用编号
	 */
	private String appId;
	/**
	 * 订购类型
	 */
	private String subType;
	/**
	 * 业务编号
	 */
	private String correlator;
	/**
	 * 扩展字段
	 */
	private String extend1;
	/**
	 * 扩展字段
	 */
	private String extend2;
	/**
	 * 扩展字段
	 */
	private String extend3;
	/**
	 * 扩展字段
	 */
	private String extend4;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("OrderVo{");
		sb.append ("subId='").append (subId).append ('\'');
		sb.append (", accountId='").append (accountId).append ('\'');
		sb.append (", packageType='").append (packageType).append ('\'');
		sb.append (", startTime='").append (startTime).append ('\'');
		sb.append (", endTime='").append (endTime).append ('\'');
		sb.append (", status='").append (status).append ('\'');
		sb.append (", reason='").append (reason).append ('\'');
		sb.append (", unSubChannel='").append (unSubChannel).append ('\'');
		sb.append (", channel='").append (channel).append ('\'');
		sb.append (", model='").append (model).append ('\'');
		sb.append (", appId='").append (appId).append ('\'');
		sb.append (", subType='").append (subType).append ('\'');
		sb.append (", correlator='").append (correlator).append ('\'');
		sb.append (", extend1='").append (extend1).append ('\'');
		sb.append (", extend2='").append (extend2).append ('\'');
		sb.append (", extend3='").append (extend3).append ('\'');
		sb.append (", extend4='").append (extend4).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
