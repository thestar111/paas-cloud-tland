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

import com.quanteng.tland.cms.database.entity.Permission;

import java.util.List;
import java.util.Map;

/**
 * <权限信息MAPPER>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface PermissionMapper
{
	/**
	 * 添加
	 *
	 * @param permission
	 */
	int add (Permission permission);

	/**
	 * 多条件查询
	 *
	 * @param params
	 * @return
	 */
	List<Permission> queryByCondition (Map<String, Object> params);

	/**
	 * 多条件查询总数
	 *
	 * @param params
	 * @return
	 */
	int countByCondition (Map<String, Object> params);

	/**
	 * 根据权限编号查询
	 *
	 * @param permsionId
	 * @return
	 */
	Permission findById (String permsionId);
}
