/**
 * 文 件 名:  ChannelMapper
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:   LJun
 * 修改时间:  2017/11/13
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.mapper;

import com.quanteng.tland.cms.database.entity.Channel;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 渠道管理Mapper
 *
 * @author LJun
 * @version 2017/11/13
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface ChannelMapper
{
	/**
	 * 新增渠道信息
	 *
	 * @param channel
	 * @throws SQLException
	 */
	int addChannel (Channel channel);

	/**
	 * 更新渠道信息
	 *
	 * @param channel
	 * @throws SQLException
	 */
	int updateChannel (Channel channel);

	/**
	 * 根据ID查询渠道信息
	 *
	 * @param channelId
	 * @return
	 * @throws SQLException
	 */
	Channel queryChannelById (String channelId);

	/**
	 * 查询渠道信息列表
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	List<Channel> queryChannelList (Map<String, Object> params);

	/**
	 * 删除渠道信息
	 *
	 * @param channelId
	 * @throws SQLException
	 */
	int deleteChannel (String channelId);

	/**
	 * 统计渠道数目
	 *
	 * @param params
	 * @throws SQLException
	 */
	int queryCountChannel (Map<String, Object> params);
}
