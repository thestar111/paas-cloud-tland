/**
 * 文 件 名:  AdsLangDto
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/25 0025
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.ads.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AdsLangDto implements Serializable
{
	/**
	 * 业务编号
	 */
	private Integer id;
	/**
	 * 广告编号
	 */
	private String advertisementId;
	/**
	 * 广告名称
	 */
	private String advertisementName;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 语言
	 */
	private String local;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AdsLang{");
		sb.append ("id=").append (id);
		sb.append (", advertisementId='").append (advertisementId).append ('\'');
		sb.append (", advertisementName='").append (advertisementName).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append (", local='").append (local).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
