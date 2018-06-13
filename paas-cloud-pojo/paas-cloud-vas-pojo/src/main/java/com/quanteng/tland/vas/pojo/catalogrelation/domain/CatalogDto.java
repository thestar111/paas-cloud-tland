/**
 * 文 件 名:  CatalogDto
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.catalogrelation.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <栏目实体 : 通用基本信息>
 *
 * @author LJun
 * @version 2018/5/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class CatalogDto implements Serializable
{
	/**
	 * 栏目编号
	 */
	private String catalogId;
	/**
	 * 栏目名称
	 */
	private String catalogName;
	/**
	 * 栏目ICON地址
	 */
	private String catalogIcon;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("CatalogDto{");
		sb.append ("catalogId='").append (catalogId).append ('\'');
		sb.append (", catalogName='").append (catalogName).append ('\'');
		sb.append (", catalogIcon='").append (catalogIcon).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
