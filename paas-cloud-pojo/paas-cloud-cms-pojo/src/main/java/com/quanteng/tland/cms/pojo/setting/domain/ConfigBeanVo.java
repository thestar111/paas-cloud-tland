/**
 * 文 件 名:  ConfigBean
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2017/9/29
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.setting.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author LJun
 * @version 2017/9/29
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class ConfigBeanVo implements Serializable
{
	private String configKey;
	private String configValue;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("ConfigBean{");
		sb.append ("configKey='").append (configKey).append ('\'');
		sb.append (", configValue='").append (configValue).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
