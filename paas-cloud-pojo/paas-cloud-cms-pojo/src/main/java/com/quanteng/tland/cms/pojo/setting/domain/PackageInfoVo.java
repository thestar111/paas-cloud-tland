/**
 * 文 件 名:  PackageInfo
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2017/8/22
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.setting.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author LJun
 * @version 2017/8/22
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class PackageInfoVo implements Serializable
{
	//套餐Id
	private String packageId;
	//套餐名称
	private String packageName;
	//有效时长（小时）
	private String usefulTime;
	//价格（分）
	private String price;
	//备注
	private String memo;
	//套餐类型
	private String packageType;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("PackageInfo{");
		sb.append ("packageId='").append (packageId).append ('\'');
		sb.append (", packageName='").append (packageName).append ('\'');
		sb.append (", usefulTime='").append (usefulTime).append ('\'');
		sb.append (", price='").append (price).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append (", packageType='").append (packageType).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
