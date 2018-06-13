/**
 * 文 件 名:  ModifyCatalogOrderNumToTopRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/6/4
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.catalog.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <普通栏目置顶请求>
 *
 * @author LJun
 * @version 2018/6/4
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class ModifyCatalogOrderNumToTopRequest extends BaseRequest
{
	/**
	 * 栏目编号
	 */
	private String catalogId;

	/**
	 * 节点类型 1叶子节点 2 非叶子节点
	 */
	private Integer noteType;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("ModifyCatalogOrderNumToTopRequest{");
		sb.append ("catalogId='").append (catalogId).append ('\'');
		sb.append (", noteType=").append (noteType);
		sb.append ('}');
		return sb.toString ();
	}
}
