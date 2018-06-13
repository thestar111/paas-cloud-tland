/**
 * 文 件 名:  QueryAdminByConditionRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huangsongbo
 * 修改时间:  2017/8/8
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.admin.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <多条件查询员工信息请求实体>
 *
 * @author huangsongbo
 * @version 2017/8/8
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryAdminByConditionRequest extends BasePageRequest
{
	/**
	 * 名称
	 */
	private String adminName;

	/**
	 * 英文名称
	 */
	private String englishName;

	/**
	 * 类型
	 */
	private String userType;

	@Override
	public String toString ()
	{
		return "QueryAdminByConditionRequest{" + "adminName='" + adminName + '\'' + ", englishName='" + englishName
				+ '\'' + ", userType='" + userType + '\'' + '}';
	}
}
