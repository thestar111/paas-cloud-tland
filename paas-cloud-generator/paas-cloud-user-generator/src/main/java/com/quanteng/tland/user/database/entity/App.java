/**
 * 文 件 名:  App
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/22
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.user.database.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <应用数据库实体>
 *
 * @author LJun
 * @version 2018/5/22
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class App implements Serializable
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
	 * ICON地址
	 */
	private String appIcon;
	/**
	 * ICON缩略图地址
	 */
	private String appIconThumb;
	/**
	 * 英文名称
	 */
	private String englishName;
	/**
	 * 星级
	 */
	private String appRate;
	/**
	 * 标签
	 */
	private String appLabel;
	/**
	 * 下载次数
	 */
	private String appDownload;
	/**
	 * 大小
	 */
	private String appSize;
	/**
	 * 版本号
	 */
	private String appVersion;
	/**
	 * 开发者
	 */
	private String developer;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 分类名称
	 */
	private String catalogName;
	/**
	 * 介绍图1
	 */
	private String bannerImg1;
	/**
	 * 介绍图2
	 */
	private String bannerImg2;
	/**
	 * 介绍图3
	 */
	private String bannerImg3;
	/**
	 * 介绍图4
	 */
	private String bannerImg4;
	/**
	 * 介绍图1缩略图地址
	 */
	private String bannerImgThumb1;
	/**
	 * 介绍图2缩略图地址
	 */
	private String bannerImgThumb2;
	/**
	 * 介绍图3缩略图地址
	 */
	private String bannerImgThumb3;
	/**
	 * 介绍图4缩略图地址
	 */
	private String bannerImgThumb4;
	/**
	 * 地址
	 */
	private String appUrl;
	/**
	 * CP编号
	 */
	private String cpId;
	/**
	 * 状态
	 */
	private String appStatus;
	/**
	 * 原因
	 */
	private String reason;
	/**
	 * 宣传图
	 */
	private String progagandaImg;
	/**
	 * 栏目编号
	 */
	private String catalogId;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("App{");
		sb.append ("appId='").append (appId).append ('\'');
		sb.append (", appName='").append (appName).append ('\'');
		sb.append (", appIcon='").append (appIcon).append ('\'');
		sb.append (", appIconThumb='").append (appIconThumb).append ('\'');
		sb.append (", englishName='").append (englishName).append ('\'');
		sb.append (", appRate='").append (appRate).append ('\'');
		sb.append (", appLabel='").append (appLabel).append ('\'');
		sb.append (", appDownload='").append (appDownload).append ('\'');
		sb.append (", appSize='").append (appSize).append ('\'');
		sb.append (", appVersion='").append (appVersion).append ('\'');
		sb.append (", developer='").append (developer).append ('\'');
		sb.append (", content='").append (content).append ('\'');
		sb.append (", catalogName='").append (catalogName).append ('\'');
		sb.append (", bannerImg1='").append (bannerImg1).append ('\'');
		sb.append (", bannerImg2='").append (bannerImg2).append ('\'');
		sb.append (", bannerImg3='").append (bannerImg3).append ('\'');
		sb.append (", bannerImg4='").append (bannerImg4).append ('\'');
		sb.append (", bannerImgThumb1='").append (bannerImgThumb1).append ('\'');
		sb.append (", bannerImgThumb2='").append (bannerImgThumb2).append ('\'');
		sb.append (", bannerImgThumb3='").append (bannerImgThumb3).append ('\'');
		sb.append (", bannerImgThumb4='").append (bannerImgThumb4).append ('\'');
		sb.append (", appUrl='").append (appUrl).append ('\'');
		sb.append (", cpId='").append (cpId).append ('\'');
		sb.append (", appStatus='").append (appStatus).append ('\'');
		sb.append (", reason='").append (reason).append ('\'');
		sb.append (", progagandaImg='").append (progagandaImg).append ('\'');
		sb.append (", catalogId='").append (catalogId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
