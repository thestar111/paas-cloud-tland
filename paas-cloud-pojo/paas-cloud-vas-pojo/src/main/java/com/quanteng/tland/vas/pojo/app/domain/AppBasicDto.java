/**
 * 文 件 名:  AppBasicDto
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/25 0025
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.app.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/5/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AppBasicDto implements Serializable
{
	/**
	 * 应用编号
	 */
	private String appId;
	/**
	 * 名称
	 */
	private String appName;
	/**
	 * 星级
	 */
	private String appRate;
	/**
	 * 版本号
	 */
	private String appVersion;
	/**
	 * 图标
	 */
	private String appIcon;
	/**
	 * 缩略图标
	 */
	private String appIconThumb;
	/**
	 * 大小
	 */
	private String appSize;
	/**
	 * 下载次数
	 */
	private String appDownload;
	/**
	 * 位置
	 */
	private Integer order;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AppBasicDto{");
		sb.append ("appId='").append (appId).append ('\'');
		sb.append (", appName='").append (appName).append ('\'');
		sb.append (", appRate='").append (appRate).append ('\'');
		sb.append (", appVersion='").append (appVersion).append ('\'');
		sb.append (", appIcon='").append (appIcon).append ('\'');
		sb.append (", appIconThumb='").append (appIconThumb).append ('\'');
		sb.append (", appSize='").append (appSize).append ('\'');
		sb.append (", appDownload='").append (appDownload).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
