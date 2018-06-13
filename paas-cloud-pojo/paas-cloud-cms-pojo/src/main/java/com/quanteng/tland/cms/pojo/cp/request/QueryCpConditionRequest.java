/**
 * 文 件 名:  QueryCpConditionRequest
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/3 0003
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.cp.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <多条件查询cp请求>
 *
 * @author zping
 * @version 2018/5/3 0003
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryCpConditionRequest extends BasePageRequest
{
	/**
	 * cp名称
	 */
	private String cpName;

	/**
	 * cp状态
	 */
	private String status;

	/**
	 *用户类型(1 : 合作伙伴用户  2 : 管理员用户)
	 */
	private Integer type;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QueryCpConditionRequest{");
		sb.append ("cpName='").append (cpName).append ('\'');
		sb.append (", status='").append (status).append ('\'');
		sb.append (", type=").append (type);
		sb.append ('}');
		return sb.toString ();
	}
}
