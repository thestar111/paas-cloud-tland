/**
 * 文 件 名:  AppModel
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/31
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.app.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <应用模型 用于修改应用信息 支持修改应用星级>
 *
 * @author LJun
 * @version 2018/5/31
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class AppModel implements Serializable
{
	/**
	 * 应用编号
	 */
	private String appId;
	/**
	 * 星级
	 */
	private String appRate;
	/**
	 * 修改状态
	 */
	private String status;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AppModel{");
		sb.append ("appId='").append (appId).append ('\'');
		sb.append (", appRate='").append (appRate).append ('\'');
		sb.append (", status='").append (status).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
