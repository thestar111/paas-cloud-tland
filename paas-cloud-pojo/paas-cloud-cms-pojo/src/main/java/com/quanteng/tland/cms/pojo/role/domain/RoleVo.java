/**
 * 文 件 名:  RoleInfo
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.role.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zhengbinggui
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class RoleVo implements Serializable
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
	 * 角色类型
	 * 0:普通管理员
	 * 1：CP管理员
	 * 2：超级管理员
	 * 3: 渠道管理员
	 */
	private String roleType;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 备注
	 */
	private String memo;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("RoleInfo{");
		sb.append ("roleId='").append (roleId).append ('\'');
		sb.append (", parentRoleId='").append (parentRoleId).append ('\'');
		sb.append (", roleType='").append (roleType).append ('\'');
		sb.append (", roleName='").append (roleName).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}