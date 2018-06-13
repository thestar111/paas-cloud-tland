/**
 * 文 件 名:  AppInfoLangVo
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/22
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.user.pojo.user.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <应用多语言实体>
 *
 * @author LJun
 * @version 2018/5/22
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AppInfoLangVo implements Serializable
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
	private String content;

	/**
	 * 本地语言
	 */
	private String local;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("AppInfoLangVo{");
		sb.append ("id=").append (id);
		sb.append (", appId='").append (appId).append ('\'');
		sb.append (", appName='").append (appName).append ('\'');
		sb.append (", appLabel='").append (appLabel).append ('\'');
		sb.append (", developer='").append (developer).append ('\'');
		sb.append (", content='").append (content).append ('\'');
		sb.append (", local='").append (local).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
