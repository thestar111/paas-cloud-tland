/**
 * 文 件 名:  PackageBean
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2017/8/22
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <套餐信息>
 *
 * @author LJun
 * @version 2017/8/22
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class Bundle extends BaseObject
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
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 最后修改时间
	 */
	private String lastUpdateTime;
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

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("Bundle{");
		sb.append ("bundleId='").append (bundleId).append ('\'');
		sb.append (", bundleName='").append (bundleName).append ('\'');
		sb.append (", useTime='").append (useTime).append ('\'');
		sb.append (", price='").append (price).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append (", bundleType='").append (bundleType).append ('\'');
		sb.append (", subCommandWord='").append (subCommandWord).append ('\'');
		sb.append (", unSubCommandWord='").append (unSubCommandWord).append ('\'');
		sb.append (", createTime='").append (createTime).append ('\'');
		sb.append (", lastUpdateTime='").append (lastUpdateTime).append ('\'');
		sb.append (", extend1='").append (extend1).append ('\'');
		sb.append (", extend2='").append (extend2).append ('\'');
		sb.append (", extend3='").append (extend3).append ('\'');
		sb.append (", extend4='").append (extend4).append ('\'');
		sb.append (", serviceID='").append (serviceID).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
