/**
 * 文 件 名:  QueryAppOrCatalogIsInBundleRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/10/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.bundleapporcatalogrelation.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <查询栏目或者应用是否在套餐中请求实体>
 *
 * @author zhengbinggui
 * @version 2017/10/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryAppOrCatalogIsInBundleRequest implements Serializable
{
	/**
	 * 套餐编号
	 */
	private String packageId;

	/**
	 * 栏目编号
	 */
	//不为空
	private String catalogId;

	/**
	 * 应用编号
	 */
	//不为空
	private String appId;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QueryAppOrCatalogIsInBundleRequest{");
		sb.append ("packageId='").append (packageId).append ('\'');
		sb.append (", catalogId='").append (catalogId).append ('\'');
		sb.append (", appId='").append (appId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}