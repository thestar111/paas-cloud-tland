/**
 * 文 件 名:  ParentCatalogRelation
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/6/6
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.catalogrelation.domain;

import com.quanteng.tland.cms.pojo.catalog.domain.CatalogVo;
import lombok.Getter;
import lombok.Setter;

/**
 * <栏目下配置栏目的实体信息>
 *
 * @author LJun
 * @version 2018/6/6
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class ParentCatalogRelation extends CatalogVo
{
	/**
	 * 栏目应用关联关系业务编号（catalogRealtion表主键）
	 */
	private String id;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("ParentCatalogRelation{");
		sb.append ("id='").append (id).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
