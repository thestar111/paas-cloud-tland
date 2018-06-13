/**
 * 文 件 名:  SubPackage
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  wanglihua
 * 修改时间:  2017/7/12 0015
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.charging.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <套餐订购关系实体>
 *
 * @author chownflat
 * @version 2017/7/12 1910
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class Order extends BaseObject
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
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 最后修改时间
	 */
	private String lastUpdateTime;
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
		final StringBuffer sb = new StringBuffer ("Order{");
		sb.append ("subId='").append (subId).append ('\'');
		sb.append (", accountId='").append (accountId).append ('\'');
		sb.append (", packageType='").append (packageType).append ('\'');
		sb.append (", startTime='").append (startTime).append ('\'');
		sb.append (", endTime='").append (endTime).append ('\'');
		sb.append (", status='").append (status).append ('\'');
		sb.append (", reason='").append (reason).append ('\'');
		sb.append (", unSubChannel='").append (unSubChannel).append ('\'');
		sb.append (", unSubChannel='").append (unSubChannel).append ('\'');
		sb.append (", channel='").append (channel).append ('\'');
		sb.append (", model='").append (model).append ('\'');
		sb.append (", appId='").append (appId).append ('\'');
		sb.append (", subType='").append (subType).append ('\'');
		sb.append (", correlator='").append (correlator).append ('\'');
		sb.append (", createTime='").append (createTime).append ('\'');
		sb.append (", lastUpdateTime='").append (lastUpdateTime).append ('\'');
		sb.append (", extend1='").append (extend1).append ('\'');
		sb.append (", extend2='").append (extend2).append ('\'');
		sb.append (", extend3='").append (extend3).append ('\'');
		sb.append (", extend4='").append (extend4).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
