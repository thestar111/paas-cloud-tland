/**
 * 文 件 名:  QueryAppNotInBundleRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/10/17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.bundleapporcatalogrelation.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <查询不在套餐中的应用请求实体>
 *
 * @author zhengbinggui
 * @version 2017/10/17
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryAppNotInBundleRequest extends BasePageRequest
{
	/**
	 * 套餐编号
	 */
	private String packageId;

	/**
	 * 应用名称
	 */
	private String appName;

	/**
	 * 应用栏目
	 */
	private String catalogId;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("QueryAppNotInBundleRequest{");
		sb.append ("packageId='").append (packageId).append ('\'');
		sb.append (", appName='").append (appName).append ('\'');
		sb.append (", catalogId='").append (catalogId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}