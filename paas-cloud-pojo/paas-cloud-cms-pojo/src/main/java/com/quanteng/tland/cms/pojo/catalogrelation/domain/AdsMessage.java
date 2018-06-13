/**
 * 文 件 名:  AdsMessage
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/16 0016
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.catalogrelation.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <广告信息>
 *
 * @author zping
 * @version 2018/5/16 0016
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AdsMessage implements Serializable
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
	 * 广告图片URL地址
	 */
	private String imgUrl;
	/**
	 * 广告类型(1：外链  2：应用   3：栏目  4：启动页广告)
	 */
	private Integer advertisementType;
	/**
	 * 目标编号
	 */
	private String targetId;
	/**
	 * 位置
	 */
	private Integer order;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AdsMessage{");
		sb.append ("advertisementId='").append (advertisementId).append ('\'');
		sb.append (", advertisementName='").append (advertisementName).append ('\'');
		sb.append (", advertisementUrl='").append (advertisementUrl).append ('\'');
		sb.append (", imgUrl='").append (imgUrl).append ('\'');
		sb.append (", advertisementType=").append (advertisementType);
		sb.append (", targetId='").append (targetId).append ('\'');
		sb.append (", order=").append (order);
		sb.append ('}');
		return sb.toString ();
	}
}
