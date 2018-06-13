/**
 * 文 件 名:  menu
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <菜单信息>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class Menu extends BaseObject
{
	/**
	 * 菜单编号
	 */
	private String menuId;
	/**
	 * 名称
	 */
	private String menuName;
	/**
	 * 父菜单编号
	 */
	private String parentMenuId;
	/**
	 * 菜单类型
	 */
	private Integer menuType;
	/**
	 * 是否叶子节点 1：否  0：叶子节点
	 */
	private Integer leaf;
	/**
	 * 序号
	 */
	private Integer sort;
	/**
	 * 菜单地址
	 */
	private String menuUrl;
	/**
	 * 备注
	 */
	private String memo;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("Menu{");
		sb.append ("menuId='").append (menuId).append ('\'');
		sb.append (", menuName='").append (menuName).append ('\'');
		sb.append (", parentMenuId='").append (parentMenuId).append ('\'');
		sb.append (", menuType=").append (menuType);
		sb.append (", leaf=").append (leaf);
		sb.append (", sort=").append (sort);
		sb.append (", menuUrl='").append (menuUrl).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
