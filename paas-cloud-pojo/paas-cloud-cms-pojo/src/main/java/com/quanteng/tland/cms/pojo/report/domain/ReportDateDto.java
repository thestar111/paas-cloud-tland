/**
 * 文 件 名:  ReportDateDto
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/1/5
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.report.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Report  DTO实体
 *
 * @author LJun
 * @version 2018/1/5
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class ReportDateDto implements Serializable
{
	/**
	 * 日前
	 **/
	private String time;
	/**
	 * PV数
	 **/
	private String pv;
	/**
	 * 目标用户
	 **/
	private String user;
	/**
	 * 业务订购用户
	 **/
	private String bussinessOrderUser;
	/**
	 * 套餐订购用户
	 **/
	private String bundleOrderUser;
	/**
	 * 付费用户
	 **/
	private String payUser;
	/**
	 * 日套餐付费用户
	 **/
	private String dailyPayUser;
	/**
	 * 周套餐付费用户
	 **/
	private String weeklyPayUser;
	/**
	 * 退订用户
	 **/
	private String unSubUser;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("ReportDateDto{");
		sb.append ("time='").append (time).append ('\'');
		sb.append (", pv='").append (pv).append ('\'');
		sb.append (", user='").append (user).append ('\'');
		sb.append (", bussinessOrderUser='").append (bussinessOrderUser).append ('\'');
		sb.append (", bundleOrderUser='").append (bundleOrderUser).append ('\'');
		sb.append (", payUser='").append (payUser).append ('\'');
		sb.append (", dailyPayUser='").append (dailyPayUser).append ('\'');
		sb.append (", weeklyPayUser='").append (weeklyPayUser).append ('\'');
		sb.append (", unSubUser='").append (unSubUser).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
