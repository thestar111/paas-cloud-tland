/**
 * 文 件 名:  Ads
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huangsongbo
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.ad.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <广告信息>
 *
 * @author huangsongbo
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AdsVo implements Serializable
{
	/**
	 * 广告编号
	 */
	private String advertisementId;

	/**
	 * 名称
	 */
	private String advertisementName;

	/**
	 * 地址
	 */
	private String advertisementUrl;

	/**
	 * 广告图片地址
	 */
	private String imgUrl;

	/**
	 * 创建时间
	 */
	private String createTime;

	/**
	 * 广告状态(0 : 禁用  1：有效)
	 */
	private String isValid;

	/**
	 * 广告类型 (1：外链  2：应用   3：栏目  4：启动页广告)
	 */
	private String advertisementType;

	/**
	 * 广告类型为应用则是应用ID，广告类型为栏目则是栏目ID
	 */
	private String targetId;

	/**
	 * 备注
	 */
	private String memo;

	/**
	 * 广告多语言
	 */
	private List<AdsLangVo> adsLangs;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AdsVo{");
		sb.append ("advertisementId='").append (advertisementId).append ('\'');
		sb.append (", advertisementName='").append (advertisementName).append ('\'');
		sb.append (", advertisementUrl='").append (advertisementUrl).append ('\'');
		sb.append (", imgUrl='").append (imgUrl).append ('\'');
		sb.append (", createTime='").append (createTime).append ('\'');
		sb.append (", isValid='").append (isValid).append ('\'');
		sb.append (", advertisementType='").append (advertisementType).append ('\'');
		sb.append (", targetId='").append (targetId).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append (", adsLangs=").append (adsLangs);
		sb.append ('}');
		return sb.toString ();
	}
}
