/**
 * 文 件 名:  CatalogMessageVo
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/16 0016
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.catalogrelation.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <父栏目子栏目关系消息实体对象>
 *
 * @author zping
 * @version 2018/5/16 0016
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class CatalogMessageVo implements Serializable
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
	 * 栏目图标地址
	 */
	private String catalogIcon;
	/**
	 * 一级栏目分类排序位置
	 */
	private Integer position;
	/**
	 * 节点类型  1 ： 叶子节点  2： 非叶子节点
	 */
	private Integer nodeType;
	/**
	 * 二级栏目分类排序位置
	 */
	private Integer order;
	/**
	 * 栏目背景图
	 */
	private String progagandaImg;

	/**
	 * 二级栏目
	 */
	private List<CatalogMessageVo> subCatalog;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("CatalogMessageVo{");
		sb.append ("catalogId='").append (catalogId).append ('\'');
		sb.append (", catalogName='").append (catalogName).append ('\'');
		sb.append (", catalogIcon='").append (catalogIcon).append ('\'');
		sb.append (", position=").append (position);
		sb.append (", nodeType=").append (nodeType);
		sb.append (", order=").append (order);
		sb.append (", subCatalog=").append (subCatalog);
		sb.append ('}');
		return sb.toString ();
	}
}
