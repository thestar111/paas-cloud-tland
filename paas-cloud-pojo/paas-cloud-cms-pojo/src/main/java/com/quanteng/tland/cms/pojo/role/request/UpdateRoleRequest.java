/**
 * 文 件 名:  UpdateRoleRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2017/8/9
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.role.request;

import com.quanteng.tland.cms.pojo.role.domain.RoleVo;
import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <修改角色信息请求实体>
 *
 * @author zhengbinggui
 * @version 2017/8/9
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class UpdateRoleRequest extends BaseRequest
{
	/**
	 * 角色信息
	 */
	private RoleVo roleVo;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("UpdateRoleRequest{");
		sb.append ("roleVo=").append (roleVo);
		sb.append ('}');
		return sb.toString ();
	}
}