/**
 * 文 件 名:  GetFormsRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  chenJian
 * 修改时间:  2017/8/24
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.report.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

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
public class GetFormsRequest extends BaseRequest
{
	/**
	 * 业务编号
	 **/
	private String serviceId;
	/**
	 * 游戏名称
	 **/
	private String appName;
	/**
	 * 起始时间 cp 方查看报表，该时间为下载记录时间
	 **/
	private String startTime;
	/**
	 * 结束时间 cp 方查看报表，该时间为下载记录时间
	 **/
	private String endTime;

	/**
	 * 下载渠道
	 */
	private String channel;

	/**
	 * 下载模式
	 */
	private String model;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("GetFormsRequest{");
		sb.append ("serviceId='").append (serviceId).append ('\'');
		sb.append (", appName='").append (appName).append ('\'');
		sb.append (", startTime='").append (startTime).append ('\'');
		sb.append (", endTime='").append (endTime).append ('\'');
		sb.append (", channel='").append (channel).append ('\'');
		sb.append (", model='").append (model).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}