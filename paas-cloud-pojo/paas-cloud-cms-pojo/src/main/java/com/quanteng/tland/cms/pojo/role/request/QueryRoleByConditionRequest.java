/**
 * 文 件 名:  QueryRoleByConditionRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.role.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <多条件查询角色信息请求实体>
 *
 * @author zhengbinggui
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryRoleByConditionRequest extends BasePageRequest
{
	/**
	 * 角色编号
	 */
	private String roleId;
	/**
	 * 父角色编号
	 */
	private String parentRoleId;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 角色类型
	 */
	private String roleType;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QueryRoleByConditionRequest{");
		sb.append ("roleId='").append (roleId).append ('\'');
		sb.append (", parentRoleId='").append (parentRoleId).append ('\'');
		sb.append (", roleName='").append (roleName).append ('\'');
		sb.append (", roleType='").append (roleType).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}