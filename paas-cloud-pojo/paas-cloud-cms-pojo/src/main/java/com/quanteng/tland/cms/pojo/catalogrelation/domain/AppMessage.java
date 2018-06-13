/**
 * 文 件 名:  AppMessage
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  chenJian
 * 修改时间:  2017/11/20
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.catalogrelation.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author chenJian
 * @version 2017/11/20
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class AppMessage implements Serializable
{
	/**
	 * 应用编号
	 */
	private String appId;
	/**
	 * 应用名称
	 */
	private String appName;
	/**
	 * 应用ICON地址
	 */
	private String appIcon;
	/**
	 * 应用ICON缩略图地址
	 */
	private String appIconThumb;
	/**
	 * 应用星级
	 */
	private String appRate;
	/**
	 * 应用版本号
	 */
	private String appVersion;
	/**
	 * 应用大小
	 */
	private String appSize;
	/**
	 * 下载次数
	 */
	private String appDownload;
	/**
	 * 开发者
	 */
	private String developer;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AppMessage{");
		sb.append (", appId='").append (appId).append ('\'');
		sb.append (", appName='").append (appName).append ('\'');
		sb.append (", appIcon='").append (appIcon).append ('\'');
		sb.append (", appIconThumb='").append (appIconThumb).append ('\'');
		sb.append (", appRate='").append (appRate).append ('\'');
		sb.append (", appVersion='").append (appVersion).append ('\'');
		sb.append (", appSize='").append (appSize).append ('\'');
		sb.append (", appDownload='").append (appDownload).append ('\'');
		sb.append (", developer='").append (developer).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}