/**
 * 文 件 名:  ReportFormsResource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  chenJian
 * 修改时间:  2017/8/24
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.report;

import com.quanteng.tland.cms.pojo.report.request.GetCpFormsReq;
import com.quanteng.tland.cms.pojo.report.request.GetDataIncomeReq;
import com.quanteng.tland.cms.pojo.report.request.GetFormsRequest;
import com.quanteng.tland.cms.pojo.report.request.GetReportListRequest;
import com.quanteng.tland.cms.pojo.report.response.GetDataIncomeResp;
import com.quanteng.tland.cms.pojo.report.response.GetReportFormsResponse;
import com.quanteng.tland.cms.pojo.report.response.GetReportListResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <报表功能模块>
 *
 * @author chenJian
 * @version 2017/8/24
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/cms/reportForms")
public interface ReportFormsResource
{
	/**
	 * 获取报表详情
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping (value = "/getReportFormList", method = RequestMethod.POST)
	GetReportFormsResponse getReportFormList (@RequestBody GetFormsRequest request);

	/**
	 * 获取cp 报表
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping (value = "/getCPReportFormList", method = RequestMethod.POST)
	GetReportFormsResponse getCPReportFormList (@RequestBody GetCpFormsReq request);

	/**
	 * 查询Report列表信息
	 *
	 * @param getReportListRequest
	 * @return
	 */
	@RequestMapping (value = "/queryPeportList", method = RequestMethod.POST)
	GetReportListResponse queryPeportList (@RequestBody GetReportListRequest getReportListRequest);

	/**
	 * 查询income列表接口
	 *
	 * @param getDataIncomeReq
	 * @return
	 */
	@RequestMapping (value = "/queryDataIncomeList", method = RequestMethod.POST)
	GetDataIncomeResp queryDataIncomeList (@RequestBody GetDataIncomeReq getDataIncomeReq);
}