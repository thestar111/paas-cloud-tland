/**
 * 文 件 名:  SysConfig
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2017/9/29
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <系统配置信息表>
 *
 * @author LJun
 * @version 2017/9/29
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class SysConfig extends BaseObject
{
	/**
	 * 配置KEY
	 */
	private String configKey;
	/**
	 * 配置VALUE
	 */
	private String configValue;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("SysConfig{");
		sb.append ("configKey='").append (configKey).append ('\'');
		sb.append (", configValue='").append (configValue).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
