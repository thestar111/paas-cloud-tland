/**
 * 文 件 名:  AdminRoleRelationMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.mapper;

import com.quanteng.tland.cms.database.entity.AdminRoleRelation;

import java.util.List;

/**
 * <管理员角色关系MAPPER>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface AdminRoleRelationMapper
{
	/**
	 * 根据管理员ID查询角色
	 *
	 * @param adminId
	 * @return
	 */
	List<AdminRoleRelation> findByAdminId (String adminId);

	/**
	 * 添加
	 *
	 * @param adminRoleRelation
	 */
	int add (AdminRoleRelation adminRoleRelation);
}
