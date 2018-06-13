/**
 * 文 件 名:  LocalMapper
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2018/5/18
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.mapper;

import com.quanteng.tland.cms.database.entity.Local;

import java.util.List;

/**
 * <国际语言Mapper>
 *
 * @author zhengbinggui
 * @version 2018/5/18
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface LocalMapper
{
	/**
	 * 添加国际语言
	 *
	 * @param local
	 * @return
	 */
	int add (Local local);

	/**
	 * 删除国际语言
	 *
	 * @param localId
	 * @return
	 */
	int delete (String localId);

	/**
	 * 修改国际语言
	 *
	 * @param local
	 * @return
	 */
	int update (Local local);

	/**
	 * 根据id查国际语言
	 *
	 * @param localId
	 * @return
	 */
	Local findById (String localId);

	/**
	 * 查询全部国际语言
	 *
	 * @return
	 */
	List<Local> query ();
}
