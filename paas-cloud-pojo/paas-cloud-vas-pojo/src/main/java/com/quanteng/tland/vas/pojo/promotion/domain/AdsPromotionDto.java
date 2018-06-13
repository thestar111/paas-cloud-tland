/**
 * 文 件 名:  AdsDto
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
 * <首页营销广告传输对象>
 *
 * @author zping
 * @version 2018/5/15 0015
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AdsPromotionDto implements Serializable
{
	/**
	 * 广告编号
	 */
	private String advertisementId;
	/**
	 * 广告名称
	 */
	private String advertisementName;
	/**
	 * 广告链接地址
	 */
	private String advertisementUrl;
	/**
	 * 广告图片地址
	 */
	private String imgUrl;
	/**
	 * 广告类型：(1：外链  2：应用   3：栏目)
	 */
	private Integer type;
	/**
	 * 目标编号(栏目编号, 应用编号)
	 */
	private String targetId;
	/**
	 * 位置
	 */
	private Integer order;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("AdsPromotionDto{");
		sb.append ("advertisementId='").append (advertisementId).append ('\'');
		sb.append (", advertisementName='").append (advertisementName).append ('\'');
		sb.append (", advertisementUrl='").append (advertisementUrl).append ('\'');
		sb.append (", imgUrl='").append (imgUrl).append ('\'');
		sb.append (", type='").append (type).append ('\'');
		sb.append (", targetId='").append (targetId).append ('\'');
		sb.append (", order=").append (order);
		sb.append ('}');
		return sb.toString ();
	}
}
