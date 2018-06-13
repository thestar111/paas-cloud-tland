/**
 * 文 件 名:  ModifyPasswordReq
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  chenJian
 * 修改时间:  2017/8/28
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.admin.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <修改用户密码请求实体>
 *
 * @author chenJian
 * @version 2017/8/28
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class ModifyPasswordReq extends BaseRequest
{
	/**
	 * 管理员id
	 */
	private String adminId;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 旧密码
	 */
	private String oldPassword;

	@Override
	public String toString ()
	{
		return "ModifyPasswordReq{" + "adminId='" + adminId + '\'' + ", password='" + password + '\''
				+ ", oldPassword='" + oldPassword + '\'' + '}';
	}
}