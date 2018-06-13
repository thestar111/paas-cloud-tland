/**
 * 文 件 名:  Catalogs
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huangsongbo
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.catalog.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <栏目信息>
 *
 * @author huangsongbo
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class CatalogVo implements Serializable
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
	 * 栏目类型  1 : 普通栏目   2 : 应用栏目  3 : 营销栏目
	 */
	private String catalogType;
	/**
	 * 栏目ICON地址
	 */
	private String catalogIcon;
	/**
	 * 宣传图地址
	 */
	private String progagandaImg;
	/**
	 * 栏目描述
	 */
	private String catalogDesc;
	/**
	 * 父栏目编号
	 */
	private String parentCatalogId;
	/**
	 * 序号
	 */
	private Integer orderNum;
	/**
	 * 节点类型  1 ： 叶子节点  2： 非叶子节点
	 */
	private Integer nodeType;
	/**
	 * 栏目多语言信息
	 */
	private List<CatalogLangVo> catalogLangVos;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("CatalogVo{");
		sb.append ("catalogId='").append (catalogId).append ('\'');
		sb.append (", catalogName='").append (catalogName).append ('\'');
		sb.append (", catalogType='").append (catalogType).append ('\'');
		sb.append (", catalogIcon='").append (catalogIcon).append ('\'');
		sb.append (", progagandaImg='").append (progagandaImg).append ('\'');
		sb.append (", catalogDesc='").append (catalogDesc).append ('\'');
		sb.append (", parentCatalogId='").append (parentCatalogId).append ('\'');
		sb.append (", orderNum=").append (orderNum);
		sb.append (", nodeType=").append (nodeType);
		sb.append (", catalogLangVos=").append (catalogLangVos);
		sb.append ('}');
		return sb.toString ();
	}
}
