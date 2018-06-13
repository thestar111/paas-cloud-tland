/**
 * 文 件 名:  UserMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.user.database.mapper;

import com.quanteng.tland.user.database.entity.App;
import com.quanteng.tland.user.database.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <用户数据库接口定义>
 *
 * @author zping
 * @version 2018/4/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface UserMapper
{
	/**
	 * 添加用户
	 *
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	int create (User user) throws SQLException;

	/**
	 * 获取用户的下载历史记录
	 *
	 * @param params
	 * @return
	 */
	List<App> getDownloadRecord (Map<String, Object> params);

	/**
	 * 统计用户的下载历史记录总数
	 *
	 * @param params
	 * @return
	 */
	int getDownloadRecordCount (Map<String, Object> params);

	/**
	 * 根据应用编号查询用户下载地址
	 *
	 * @param appId
	 * @return
	 */
	App queryAppDownloadUrl (String appId);
}
