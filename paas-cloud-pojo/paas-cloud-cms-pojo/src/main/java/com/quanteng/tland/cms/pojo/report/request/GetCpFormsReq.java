/**
 * 文 件 名:  GetCpFormsReq
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  chenJian
 * 修改时间:  2017/10/16
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
 * @version 2017/10/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class GetCpFormsReq extends BaseRequest
{

	/**
	 * cpd
	 */
	private String cpId;

	/**
	 * cp 状态
	 */
	private String cpStatus;

	/**
	 * cp 名字
	 */
	private String cpName;

	/**
	 * cp 父id
	 */
	private String parentCpId;

	/***
	 * 限制查询的时间段。
	 * @return
	 */
	private String endTime;
	private String beginTime;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("GetCpFormsReq{");
		sb.append ("cpId='").append (cpId).append ('\'');
		sb.append (", cpStatus='").append (cpStatus).append ('\'');
		sb.append (", cpName='").append (cpName).append ('\'');
		sb.append (", parentCpId='").append (parentCpId).append ('\'');
		sb.append (", endTime='").append (endTime).append ('\'');
		sb.append (", beginTime='").append (beginTime).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}