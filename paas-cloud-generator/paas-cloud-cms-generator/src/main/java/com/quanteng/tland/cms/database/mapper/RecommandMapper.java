/**
 * 文 件 名:  RecommandMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/1/24 0024
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.mapper;

import com.quanteng.tland.cms.database.entity.Recommand;

import java.sql.SQLException;

/**
 * <应用推荐Mapper>
 *
 * @author zping
 * @version 2018/1/24 0024
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface RecommandMapper
{

	/**
	 * 删除应用推荐
	 *
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int delete (Integer id);

	/**
	 * 插入应用推荐信息
	 *
	 * @param recommand
	 * @return
	 * @throws SQLException
	 */
	int addRecommand (Recommand recommand);

	/**
	 * 查询推荐信息
	 *
	 * @return
	 * @throws SQLException
	 */
	Recommand queryRecommand ();
}
