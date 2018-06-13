/**
 * 文 件 名:  PermissionRoleRelation
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <权限角色关系>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class PermissionRoleRelation extends BaseObject
{
	/**
	 * 业务编号
	 */
	private String id;
	/**
	 * 权限编号
	 */
	private String permissionId;
	/**
	 * 角色编号
	 */
	private String roleId;
	/**
	 * 类是否可以被该角色操作：
	 * 1：不可操作但可分配
	 * 2：可操作但不能分配
	 * 3：可操作且可分配类是否可以被该角色操作：
	 * 1：不可操作但可分配
	 * 2：可操作但不能分配
	 * 3：可操作且可分配
	 */
	private String optType;
	/**
	 * 备注
	 */
	private String memo;

	@Override
	public String toString ()
	{
		return "PermissionRoleRelation{" + "id='" + id + '\'' + ", permissionId='" + permissionId + '\'' + ", roleId='"
				+ roleId + '\'' + ", optType='" + optType + '\'' + ", memo='" + memo + '\'' + '}';
	}
}
