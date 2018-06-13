/**
 * 文 件 名:  ParentCatalog
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/28 0028
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * <栏目下配置栏目的实体信息>
 *
 * @author zping
 * @version 2018/5/28 0028
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class ParentCatalog extends Catalog
{

	/**
	 * 父栏目编号
	 */
	private String parentCatalogId;
	/**
	 * 父栏目名称
	 */
	private String parentCatalogName;
	/**
	 * 父栏目类型
	 */
	private Integer type;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("ParentCatalog{");
		sb.append ("parentCatalogId='").append (parentCatalogId).append ('\'');
		sb.append (", parentCatalogName='").append (parentCatalogName).append ('\'');
		sb.append (", type='").append (type).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
