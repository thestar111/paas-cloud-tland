/**
 * 文 件 名:  BundleDto
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.bundle.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <套餐信息实体>
 *
 * @author LJun
 * @version 2018/5/15
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class BundleDto implements Serializable
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
	 * 套餐类型
	 */
	private String bundleType;

	/**
	 * 套餐多语言信息
	 */
	private List<BundleLangDto> bundleLangDtoList;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("BundleDto{");
		sb.append ("bundleId='").append (bundleId).append ('\'');
		sb.append (", bundleName='").append (bundleName).append ('\'');
		sb.append (", useTime='").append (useTime).append ('\'');
		sb.append (", price='").append (price).append ('\'');
		sb.append (", bundleType='").append (bundleType).append ('\'');
		sb.append (", bundleLangDtoList=").append (bundleLangDtoList);
		sb.append ('}');
		return sb.toString ();
	}
}
