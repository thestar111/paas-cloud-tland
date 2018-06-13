/**
 * 文 件 名:  Permission
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
 * <权限信息>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class Permission extends BaseObject
{
	/**
	 * 权限编号
	 */
	private String permissionId;
	/**
	 * 名称
	 */
	private String permissionName;
	/**
	 * 标识
	 */
	private String permissionFlag;
	/**
	 * 菜单编号
	 */
	private String menuId;
	/**
	 * 备注
	 */
	private String memo;

	@Override
	public String toString ()
	{
		return "Permission{" + "permissionId='" + permissionId + '\'' + ", permissionName='" + permissionName + '\''
				+ ", permissionFlag='" + permissionFlag + '\'' + ", menuId='" + menuId + '\'' + ", memo='" + memo + '\''
				+ '}';
	}
}
