/**
 * 文 件 名:  PermsionInfo
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.permission.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <权限信息>
 *
 * @author zhengbinggui
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class PermissionVo implements Serializable
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
		return "PermissionVo{" + "permissionId='" + permissionId + '\'' + ", permissionName='" + permissionName + '\''
				+ ", permissionFlag='" + permissionFlag + '\'' + ", menuId='" + menuId + '\'' + ", memo='" + memo + '\''
				+ '}';
	}
}