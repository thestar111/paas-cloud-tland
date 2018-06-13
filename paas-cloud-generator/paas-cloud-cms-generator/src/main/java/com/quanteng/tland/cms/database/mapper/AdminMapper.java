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

import com.quanteng.tland.cms.database.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <系统管理员MAPPER>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface AdminMapper
{
	/**
	 * 添加
	 *
	 * @param admin
	 */
	int add (Admin admin);

	/**
	 * 修改
	 *
	 * @param admin
	 */
	int modify (Admin admin);

	/**
	 * 总数
	 *
	 * @param params
	 * @return
	 */
	int queryCount (Map<String, Object> params);

	/**
	 * 查询列表
	 *
	 * @param params
	 * @return
	 */
	List<Admin> queryList (Map<String, Object> params);

	/**
	 * 根据账号查询
	 *
	 * @param adminAccount
	 * @return
	 */
	Admin findAdminByAccount (String adminAccount);

	/**
	 * 移除管理员
	 *
	 * @param adminId
	 */
	int removeAdmin (String adminId);

	/**
	 * 获取管理员具体信息
	 *
	 * @param adminId
	 * @return
	 */
	Admin queryAdminById (String adminId);

	/**
	 * 修改管理密码
	 *
	 * @param adminId
	 * @param password
	 * @param oldPassword
	 * @return
	 */
	int modifyAdminPassword (@Param ("adminId") String adminId, @Param ("password") String password,
			@Param ("oldPassword") String oldPassword);

	/**
	 * 查询管理员的cpid
	 *
	 * @tags @return
	 * return String
	 */
	String getCpIdByAccount (String adminAccount);
}
