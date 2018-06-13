/**
 * 文 件 名:  QueryAppByCatalogTypeRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.catalogrelation.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <根据应用栏目分类查询应用信息请求>
 *
 * @author LJun
 * @version 2018/5/17
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryAppByCatalogTypeRequest extends BasePageRequest
{
	/**
	 * 栏目类型 (1 : 普通栏目   2 : 应用栏目  3 : 营销栏目)
	 */
	private String type;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("QueryAppByCatalogTypeRequest{");
		sb.append ("type='").append (type).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
