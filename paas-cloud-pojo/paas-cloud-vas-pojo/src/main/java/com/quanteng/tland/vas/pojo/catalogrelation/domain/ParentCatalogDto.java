/**
 * 文 件 名:  ParentCatalogDto
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/25 0025
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.catalogrelation.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <父栏目传输对象>
 *
 * @author zping
 * @version 2018/5/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class ParentCatalogDto extends CatalogDto
{
	/**
	 * 宣传图地址
	 */
	private String progagandaImg;
	/**
	 * 节点类型  1 ： 叶子节点  2： 非叶子节点
	 */
	private Integer nodeType;
	/**
	 * 排序位置
	 */
	private Integer position;
	/**
	 * 子栏目信息
	 */
	private List<SubCatalogDto> subCatalog;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("ParentCatalogDto{");
		sb.append ("position=").append (position);
		sb.append (", subCatalog=").append (subCatalog);
		sb.append ('}');
		return sb.toString ();
	}
}
