/**
 * 文 件 名:  ModSysParamReq
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2017/8/22
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.setting.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <修改系统配置请求>
 *
 * @author LJun
 * @version 2017/8/22
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class ModSysParamReq implements Serializable
{
	//修改值
	private String configValue;
	//修改条件
	private String configKey;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("ModSysParamReq{");
		sb.append ("configValue='").append (configValue).append ('\'');
		sb.append (", configKey='").append (configKey).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
