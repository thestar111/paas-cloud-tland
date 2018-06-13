/**
 * 文 件 名:  MenuLang
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
 * <菜单多语言实体>
 *
 * @author zping
 * @version 2018/4/18 0018
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
@NoArgsConstructor
public class MenuLang extends BaseObject
{

	/**
	 * 业务编号
	 */
	private Integer id;
	/**
	 * 菜单编号
	 */
	private String menuId;
	/**
	 * 菜单名称
	 */
	private String menuName;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 语言
	 */
	private String local;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("MenuLang{");
		sb.append ("id=").append (id);
		sb.append (", menuId='").append (menuId).append ('\'');
		sb.append (", menuName='").append (menuName).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append (", local='").append (local).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
