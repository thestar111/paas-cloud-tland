/**
 * 文 件 名:  SysSettingsMapper
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2017/8/22
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.mapper;

import com.quanteng.tland.cms.database.entity.Bundle;
import com.quanteng.tland.cms.database.entity.SysConfig;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <系统配置Mapper定义>
 *
 * @author LJun
 * @version 2017/8/22
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface SysSettingsMapper
{

	/**
	 * 根据configKey查询套餐信息
	 *
	 * @return
	 */
	Bundle queryPackageConfigValue (String configKey);

	/**
	 * 根据configKey查询配置信息
	 *
	 * @return
	 */
	List<SysConfig> queryConfigValue (Map<String, Object> params);

	/**
	 * 修改配置信息当前值
	 *
	 * @param params
	 */
	int modifyConfigValue (Map<String, Object> params);

}
