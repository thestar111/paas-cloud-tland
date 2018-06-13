/**
 * 文 件 名:  Catalog
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/10 0010
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <目录信息>
 *
 * @author zping
 * @version 2017/7/10 0010
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class Catalog extends BaseObject
{
	/**
	 * 栏目编号
	 */
	private String catalogId;
	/**
	 * 名称
	 */
	private String catalogName;
	/**
	 * 栏目类型  1 : 普通栏目   2 : 应用栏目  3 : 营销栏目
	 */
	private String catalogType;
	/**
	 * ICON地址
	 */
	private String catalogIcon;
	/**
	 * 描述
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
	 * 宣传图地址
	 */
	private String progagandaImg;
	/**
	 * 栏目配置表主键
	 * 只有查询HOT tag栏目下的栏目时使用
	 */
	private String id;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("Catalog{");
		sb.append ("catalogId='").append (catalogId).append ('\'');
		sb.append (", catalogName='").append (catalogName).append ('\'');
		sb.append (", catalogType='").append (catalogType).append ('\'');
		sb.append (", catalogIcon='").append (catalogIcon).append ('\'');
		sb.append (", catalogDesc='").append (catalogDesc).append ('\'');
		sb.append (", parentCatalogId='").append (parentCatalogId).append ('\'');
		sb.append (", orderNum=").append (orderNum);
		sb.append (", nodeType=").append (nodeType);
		sb.append (", progagandaImg='").append (progagandaImg).append ('\'');
		sb.append (", id='").append (id).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
