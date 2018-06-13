/**
 * 文 件 名:  CatalogLang
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/18 0018
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <栏目多语言实体>
 *
 * @author zping
 * @version 2018/4/18 0018
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
@NoArgsConstructor
public class CatalogLang extends BaseObject
{

	/**
	 * 业务编号
	 */
	private Integer id;

	/**
	 * 栏目编号
	 */
	private String catalogId;
	/**
	 * 名称
	 */
	private String catalogName;
	/**
	 * 描述
	 */
	private String catalogDesc;
	/**
	 * 语言
	 */
	private String local;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("CatalogLang{");
		sb.append ("id=").append (id);
		sb.append (", catalogId='").append (catalogId).append ('\'');
		sb.append (", catalogName='").append (catalogName).append ('\'');
		sb.append (", catalogDesc='").append (catalogDesc).append ('\'');
		sb.append (", local='").append (local).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
