/**
 * 文 件 名:  BundleVo
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/4 0004
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.bundle.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <套餐实体VO信息>
 *
 * @author zping
 * @version 2018/5/4 0004
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class BundleVo implements Serializable
{
	/**
	 * 套餐Id
	 */
	private String bundleId;
	/**
	 * 套餐名称
	 */
	private String bundleName;
	/**
	 * 有效时长（小时）
	 */
	private String useTime;
	/**
	 * 价格（分）
	 */
	private String price;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 套餐类型
	 */
	private String bundleType;
	/**
	 * 订购关键字
	 */
	private String subCommandWord;
	/**
	 * 退订关键字
	 */
	private String unSubCommandWord;
	/**
	 * 扩展字段1
	 */
	private String extend1;
	/**
	 * 扩展字段2
	 */
	private String extend2;
	/**
	 * 扩展字段3
	 */
	private String extend3;
	/**
	 * 扩展字段4
	 */
	private String extend4;
	/**
	 * 服务编号
	 */
	private String serviceID;
	/**
	 * 套餐多语言信息
	 */
	private List<BundleLangVo> bundleLangs;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("BundleVo{");
		sb.append ("bundleId='").append (bundleId).append ('\'');
		sb.append (", bundleName='").append (bundleName).append ('\'');
		sb.append (", useTime='").append (useTime).append ('\'');
		sb.append (", price='").append (price).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append (", bundleType='").append (bundleType).append ('\'');
		sb.append (", subCommandWord='").append (subCommandWord).append ('\'');
		sb.append (", unSubCommandWord='").append (unSubCommandWord).append ('\'');
		sb.append (", extend1='").append (extend1).append ('\'');
		sb.append (", extend2='").append (extend2).append ('\'');
		sb.append (", extend3='").append (extend3).append ('\'');
		sb.append (", extend4='").append (extend4).append ('\'');
		sb.append (", serviceID='").append (serviceID).append ('\'');
		sb.append (", bundleLangs=").append (bundleLangs);
		sb.append ('}');
		return sb.toString ();
	}
}
