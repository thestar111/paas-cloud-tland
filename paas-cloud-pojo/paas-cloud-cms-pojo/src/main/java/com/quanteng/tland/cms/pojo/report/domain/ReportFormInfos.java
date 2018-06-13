/**
 * 文 件 名:  ReportFormInfos
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  chenJian
 * 修改时间:  2017/8/24
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.report.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author chenJian
 * @version 2017/8/24
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class ReportFormInfos implements Serializable
{
	/**
	 * It is equals to the APP Id
	 **/
	private String serviceCode;
	private String appName;
	private String cpName;

	/**
	 * 报表下载总次数
	 **/
	private Integer downloadTimes;
	/**
	 * 报表有效下载次数
	 **/
	private Integer effectiveClicks;

	/**
	 * cp 报表独有字段
	 **/
	private String cpId;
	private String cpStatus;
	private String parentCpId;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("ReportFormInfos{");
		sb.append ("serviceCode='").append (serviceCode).append ('\'');
		sb.append (", appName='").append (appName).append ('\'');
		sb.append (", cpName='").append (cpName).append ('\'');
		sb.append (", downloadTimes=").append (downloadTimes);
		sb.append (", effectiveClicks=").append (effectiveClicks);
		sb.append (", cpId='").append (cpId).append ('\'');
		sb.append (", cpStatus='").append (cpStatus).append ('\'');
		sb.append (", ParentCpId='").append (parentCpId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}