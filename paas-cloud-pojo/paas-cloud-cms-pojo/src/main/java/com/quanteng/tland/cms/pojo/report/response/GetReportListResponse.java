/**
 * 文 件 名:  GetReportListResponse
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/1/5
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.report.response;

import com.quanteng.tland.cms.pojo.report.domain.ReportDateDto;
import com.quanteng.tland.common.domain.Result;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 获取Report数据列表响应
 *
 * @author LJun
 * @version 2018/1/5
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class GetReportListResponse extends Result
{
	/**
	 * report数据列表
	 **/
	private List<ReportDateDto> reportDateDtoList;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("GetReportListResponse{");
		sb.append ("reportDateDtoList=").append (reportDateDtoList);
		sb.append ('}');
		return sb.toString ();
	}
}
