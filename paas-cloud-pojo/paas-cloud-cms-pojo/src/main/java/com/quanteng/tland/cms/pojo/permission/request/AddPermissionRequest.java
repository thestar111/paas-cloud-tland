/**
 * 文 件 名:  AddPermissionRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.permission.request;

import com.quanteng.tland.cms.pojo.permission.domain.PermissionVo;
import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <添加权限信息请求实体>
 *
 * @author zhengbinggui
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AddPermissionRequest extends BaseRequest
{
	/**
	 * 权限信息
	 */
	private PermissionVo permissionVo;

	@Override
	public String toString ()
	{
		return "AddPermissionRequest{" + "permissionVo=" + permissionVo + '}';
	}
}