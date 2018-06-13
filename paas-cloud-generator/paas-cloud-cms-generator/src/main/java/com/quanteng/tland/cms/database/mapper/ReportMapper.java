/**
 * 文 件 名:  ReportMapper
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  chenJian
 * 修改时间:  2017/8/24
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.mapper;

import com.quanteng.tland.cms.database.entity.ReportForm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <报表MAPPER>
 *
 * @author chenJian
 * @version 2017/8/24
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface ReportMapper
{
	/**
	 * 查询基本报表信息
	 *
	 * @return
	 */
	List<ReportForm> gainReportForms (Map<String, Object> params);

	/**
	 * 统计下载次数
	 *
	 * @param params
	 * @return
	 */
	Integer countDownTimes (Map<String, Object> params);

	/**
	 * 统计有效点击次数
	 *
	 * @param params
	 * @return
	 */
	Integer countEffectiveClickTimes (Map<String, Object> params);

	/***
	 * 统计总共的appId 和cpinfo 关联条数
	 */
	Integer countReportForms (Map<String, Object> params);

	/**
	 * 统计 按此套餐app 有效点击次数
	 */
	Integer countOneDemandClickTimes (Map<String, Object> params);

	/**
	 * 查询需要 统计报表的 cp列表
	 *
	 * @return
	 */
	List<ReportForm> gainAllCPToForms (Map<String, Object> params);

	/**
	 * 统计 cp个数
	 *
	 * @return
	 */
	Integer countCpTotalNumber (Map<String, Object> params);

	/**
	 * 统计cp下载总次数
	 *
	 * @param params
	 * @return
	 */
	Integer gainCPDownloadTimes (Map<String, Object> params);

	/**
	 * 统计周期套餐有效下载次数
	 *
	 * @param params
	 * @return
	 */
	Integer countedCpPackageTimes (Map<String, Object> params);

	/**
	 * 统计按次套餐有效下载次数
	 *
	 * @param params
	 * @return
	 */
	Integer countedCpOnDemandTimes (Map<String, Object> params);
}