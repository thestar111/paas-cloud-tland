/**
 * 文 件 名:  QueryAppByCatalogIdRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.catalogrelation.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * 根据栏目编号查询应用信息请求
 *
 * @author LJun
 * @version 2018/5/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryAppByCatalogIdRequest extends BasePageRequest
{
	/**
	 * 栏目编号
	 */
	private String catalogId;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("QueryAppByCatalogIdRequest{");
		sb.append ("catalogId='").append (catalogId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
