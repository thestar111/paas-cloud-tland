/**
 * 文 件 名:  AddPermissionRoleRelationRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.permissionrolerelation.request;

import com.quanteng.tland.cms.pojo.permissionrolerelation.domain.PermissionRoleRelationVo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <添加角色权限关联关系请求实体>
 *
 * @author zhengbinggui
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AddPermissionRoleRelationRequest implements Serializable
{
	/**
	 * 角色权限关联关系信息
	 */
	private PermissionRoleRelationVo permissionRoleRelationVo;

	@Override
	public String toString ()
	{
		return "AddPermissionRoleRelationRequest{" + "permissionRoleRelationVo=" + permissionRoleRelationVo + '}';
	}
}