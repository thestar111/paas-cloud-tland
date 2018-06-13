/**
 * 文 件 名:  GetReportListRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/1/5
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.report.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * 获取Report数据列表请求
 *
 * @author LJun
 * @version 2018/1/5
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class GetReportListRequest extends BaseRequest
{
	/**
	 * 开始时间  应为月初第一天
	 **/
	private String beginTime;
	/**
	 * 结束时间  应为月末最后一天
	 **/
	private String endTime;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("GetReportListRequest{");
		sb.append ("beginTime='").append (beginTime).append ('\'');
		sb.append (", endTime='").append (endTime).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
