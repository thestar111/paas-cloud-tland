/**
 * 文 件 名:  App
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/15 0015
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.promotion.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <首页营销应用传输对象>
 *
 * @author zping
 * @version 2018/5/15 0015
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AppPromotionDto implements Serializable
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
	 * 星级
	 */
	private String appRate;
	/**
	 * 应用版本号
	 */
	private String appVersion;
	/**
	 * ICON地址
	 */
	private String appIcon;
	/**
	 * ICON缩略图地址
	 */
	private String appIconThumb;
	/**
	 * 应用大小
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
		final StringBuilder sb = new StringBuilder ("AppPromotionDto{");
		sb.append ("appId='").append (appId).append ('\'');
		sb.append (", appName='").append (appName).append ('\'');
		sb.append (", appRate='").append (appRate).append ('\'');
		sb.append (", appVersion='").append (appVersion).append ('\'');
		sb.append (", appIcon='").append (appIcon).append ('\'');
		sb.append (", appIconThumb='").append (appIconThumb).append ('\'');
		sb.append (", appSize='").append (appSize).append ('\'');
		sb.append (", appDownload='").append (appDownload).append ('\'');
		sb.append (", order='").append (order).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
