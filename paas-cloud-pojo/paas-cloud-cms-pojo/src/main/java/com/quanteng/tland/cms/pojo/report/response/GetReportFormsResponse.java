/**
 * 文 件 名:  GetReportFormsResponse
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  chenJian
 * 修改时间:  2017/8/24
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.report.response;

import com.quanteng.tland.cms.pojo.report.domain.ReportFormInfos;
import com.quanteng.tland.common.domain.Result;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
public class GetReportFormsResponse extends Result
{
	private List<ReportFormInfos> formList;

	private Integer total = 0;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("GetReportFormsResponse{");
		sb.append ("formList=").append (formList);
		sb.append (", total=").append (total);
		sb.append ('}');
		return sb.toString ();
	}
}