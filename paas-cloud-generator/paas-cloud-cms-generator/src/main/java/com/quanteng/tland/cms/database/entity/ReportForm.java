/**
 * 文 件 名:  ReportForm
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  chenJian
 * 修改时间:  2017/8/24
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * 报表模型
 *
 * @author chenJian
 * @version 2017/8/24
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class ReportForm extends BaseObject
{
	/**
	 * It is equals to the APP Id
	 **/
	private String serviceCode;
	/**
	 * 应用名称
	 */
	private String appName;
	/**
	 * CP名称
	 */
	private String cpName;

	/**
	 * only for cp ReportForm
	 **/
	private String cpId;
	/**
	 * 父CP编号
	 */
	private String parentCpId;
	/**
	 * CP状态
	 */
	private String cpStatus;
	/**
	 * 下载次数
	 */
	private Integer cpDownloadTimes;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("ReportForm{");
		sb.append ("serviceCode='").append (serviceCode).append ('\'');
		sb.append (", appName='").append (appName).append ('\'');
		sb.append (", cpName='").append (cpName).append ('\'');
		sb.append (", cpId='").append (cpId).append ('\'');
		sb.append (", parentCpId='").append (parentCpId).append ('\'');
		sb.append (", cpStatus='").append (cpStatus).append ('\'');
		sb.append (", cpDownloadTimes=").append (cpDownloadTimes);
		sb.append ('}');
		return sb.toString ();
	}
}