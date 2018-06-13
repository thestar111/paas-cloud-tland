/**
 * 文 件 名:  QueryPermissionByConditionRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.permission.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <多条件查询权限信息请求实体>
 *
 * @author zhengbinggui
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryPermissionByConditionRequest extends BasePageRequest
{
	/**
	 * 权限名称
	 */
	private String permissionName;
	/**
	 * 权限标识
	 */
	private String permissionFlag;
	/**
	 * 菜单编号
	 */
	private String menuId;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("QueryPermissionByConditionRequest{");
		sb.append ("permissionName='").append (permissionName).append ('\'');
		sb.append (", permissionFlag='").append (permissionFlag).append ('\'');
		sb.append (", menuId='").append (menuId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}