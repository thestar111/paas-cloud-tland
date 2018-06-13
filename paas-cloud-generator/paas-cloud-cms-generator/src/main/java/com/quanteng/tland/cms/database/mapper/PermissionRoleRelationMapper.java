/**
 * 文 件 名:  AdminMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.mapper;

import com.quanteng.tland.cms.database.entity.PermissionRoleRelation;

import java.util.List;

/**
 * <权限角色关系MAPPER>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface PermissionRoleRelationMapper
{
	/**
	 * 添加
	 *
	 * @param permissionRoleRelation
	 */
	int add (PermissionRoleRelation permissionRoleRelation);

	/**
	 * 根据角色查询权限信息
	 *
	 * @param roleId
	 * @return
	 */
	List<PermissionRoleRelation> queryByRoleId (String roleId);
}
