/**
 * 文 件 名:  AdminRole
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huangsongbo
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.adminrolerelation.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <管理员角色管理信息>
 *
 * @author huangsongbo
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AdminRoleRelationVo implements Serializable
{
	/**
	 * 业务编号
	 */
	private String id;

	/**
	 * 管理员编号
	 */
	private String adminId;

	/**
	 * 角色编号
	 */
	private String roleId;

	/**
	 * 备注
	 */
	private String memo;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AdminRole{");
		sb.append ("id='").append (id).append ('\'');
		sb.append (", adminId='").append (adminId).append ('\'');
		sb.append (", roleId='").append (roleId).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
