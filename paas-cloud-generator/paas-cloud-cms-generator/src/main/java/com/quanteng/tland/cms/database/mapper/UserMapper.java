/**
 * 文 件 名:  UserMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/10 0010
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.mapper;

import com.quanteng.tland.cms.database.entity.User;

/**
 * <用户Mapper>
 *
 * @author zping
 * @version 2017/7/10 0010
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface UserMapper
{
	/**
	 * 添加用户信息
	 *
	 * @param user
	 */
	void addUser (User user);

	/**
	 * 根据ID查询用户信息
	 *
	 * @param id
	 * @return
	 */
	User queryById (String id);
}
