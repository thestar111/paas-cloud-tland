/**
 * 文 件 名:  QueryCatalogInBundleRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/10/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.bundleapporcatalogrelation.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <查询套餐中的栏目请求实体>
 *
 * @author zhengbinggui
 * @version 2017/10/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryCatalogInBundleRequest extends BasePageRequest
{
	/**
	 * 套餐编号
	 */
	private String packageId;

	@Override
	public String toString ()
	{
		return "QueryCatalogInBundleRequest{" + ", packageId='" + packageId + '\'' + '}';
	}
}