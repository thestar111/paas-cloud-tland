/**
 * 文 件 名:  BundleAppOrCatalogRelationVo
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/10/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.bundleapporcatalogrelation.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * < 套餐应用或栏目关联关系信息>
 *
 * @author zhengbinggui
 * @version 2017/10/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class BundleAppOrCatalogRelationVo implements Serializable
{
	//主键id
	private String id;

	//套餐id
	private String packageId;

	//类型 0:栏目 1:应用
	private Integer type;

	//栏目id
	private String catalogId;

	//应用id
	private String appId;

	//备注
	private String memo;

	//应用名称
	private String appName;

	//栏目名称 当查询的为应用时为app所属的栏目名称，当查询的为栏目时为栏目对应的栏目名称
	private String catalogName;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("BundleAppOrCatalogRelationVo{");
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