/**
 * 文 件 名:  AppLangDto
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/11
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.app.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <App多语言实体类>
 *
 * @author LJun
 * @version 2018/5/11
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class AppLangDto implements Serializable
{
	/**
	 * 业务编号
	 */
	private Integer id;

	/**
	 * 应用编号
	 */
	private String appId;

	/**
	 * 应用名称
	 */
	private String appName;

	/**
	 * 应用标签
	 */
	private String appLabel;

	/**
	 * 开发者
	 */
	private String developer;

	/**
	 * 应用内容
	 */
	private String appContent;

	/**
	 * 本地语言
	 */
	private String local;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("AppLangDto{");
		sb.append ("id=").append (id);
		sb.append (", appId='").append (appId).append ('\'');
		sb.append (", appName='").append (appName).append ('\'');
		sb.append (", appLabel='").append (appLabel).append ('\'');
		sb.append (", developer='").append (developer).append ('\'');
		sb.append (", appContent='").append (appContent).append ('\'');
		sb.append (", local='").append (local).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
