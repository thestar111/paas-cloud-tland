/**
 * 文 件 名:  CatalogDto
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/15 0015
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.promotion.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <APP首页营销分类实体信息传输对象>
 *
 * @author zping
 * @version 2018/5/15 0015
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class CatalogPromotionDto<T> implements Serializable
{
	/**
	 * 分类编号
	 */
	private String catalogId;
	/**
	 * 分类名称
	 */
	private String catalogName;
	/**
	 * 栏目图标地址
	 */
	private String catalogIcon;
	/**
	 * 关系类型  1 : 首页广告   3 ：首页应用
	 */
	private Integer type;
	/**
	 * 排序位置
	 */
	private Integer position;
	/**
	 * 目标响应对象
	 */
	private T target;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("CatalogPromotionDto{");
		sb.append ("catalogId='").append (catalogId).append ('\'');
		sb.append (", catalogName='").append (catalogName).append ('\'');
		sb.append (", catalogIcon='").append (catalogIcon).append ('\'');
		sb.append (", type=").append (type);
		sb.append (", position='").append (position).append ('\'');
		sb.append (", target=").append (target);
		sb.append ('}');
		return sb.toString ();
	}
}
