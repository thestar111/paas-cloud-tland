/**
 * 文 件 名:  PermsionRoleRlatInfo
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.permissionrolerelation.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <角色权限关联关系信息>
 *
 * @author zhengbinggui
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class PermissionRoleRelationVo implements Serializable
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
		return "PermissionRoleRelationVo{" + "id='" + id + '\'' + ", permissionId='" + permissionId + '\''
				+ ", roleId='" + roleId + '\'' + ", optType='" + optType + '\'' + ", memo='" + memo + '\'' + '}';
	}
}