/**
 * 文 件 名:  AppDto
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
import java.util.List;

/**
 * <App实体类>
 *
 * @author LJun
 * @version 2018/5/11
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AppDto extends AppBasicDto
{
	/**
	 * 介绍内容
	 */
	private String appContent;
	/**
	 * 标签
	 */
	private String appLabel;
	/**
	 * 图片1
	 */
	private String bannerImg1;
	/**
	 * 图片2
	 */
	private String bannerImg2;
	/**
	 * 图片3
	 */
	private String bannerImg3;
	/**
	 * 图片4
	 */
	private String bannerImg4;

	/**
	 * 图片缩略图1
	 */
	private String bannerImgThumb1;
	/**
	 * 图片缩略图2
	 */
	private String bannerImgThumb2;
	/**
	 * 图片缩略图3
	 */
	private String bannerImgThumb3;
	/**
	 * 图片缩略图4
	 */
	private String bannerImgThumb4;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("AppDto{");
		sb.append (", appContent='").append (appContent).append ('\'');
		sb.append (", appLabel='").append (appLabel).append ('\'');
		sb.append (", bannerImg1='").append (bannerImg1).append ('\'');
		sb.append (", bannerImg2='").append (bannerImg2).append ('\'');
		sb.append (", bannerImg3='").append (bannerImg3).append ('\'');
		sb.append (", bannerImg4='").append (bannerImg4).append ('\'');
		sb.append (", bannerImgThumb1='").append (bannerImgThumb1).append ('\'');
		sb.append (", bannerImgThumb2='").append (bannerImgThumb2).append ('\'');
		sb.append (", bannerImgThumb3='").append (bannerImgThumb3).append ('\'');
		sb.append (", bannerImgThumb4='").append (bannerImgThumb4).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
