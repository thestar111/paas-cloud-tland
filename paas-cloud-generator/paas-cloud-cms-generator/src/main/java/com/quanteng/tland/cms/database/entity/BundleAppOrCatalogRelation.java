/**
 * 文 件 名:  BundleAppOrCatalogRelation
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/10/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <配置点播套餐与APP关系: 配置套餐可以下载指定游戏>
 *
 * @author zhengbinggui
 * @version 2017/10/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class BundleAppOrCatalogRelation extends BaseObject
{
	/**
	 * 主键id
	 */
	private String id;

	/**
	 * 套餐id
	 */
	private String packageId;

	/**
	 * 类型 0:栏目 1:应用
	 */
	private Integer type;

	/**
	 * 栏目id
	 */
	private String catalogId;

	/**
	 * 应用id
	 */
	private String appId;

	/**
	 * 备注
	 */
	private String memo;

	/**
	 * 应用名称
	 */
	private String appName;

	/**
	 * 栏目名称
	 */
	private String catalogName;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("BundleAppOrCatalogRelation{");
		sb.append ("id='").append (id).append ('\'');
		sb.append (", packageId='").append (packageId).append ('\'');
		sb.append (", type=").append (type);
		sb.append (", catalogId='").append (catalogId).append ('\'');
		sb.append (", appId='").append (appId).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append (", appName='").append (appName).append ('\'');
		sb.append (", catalogName='").append (catalogName).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}