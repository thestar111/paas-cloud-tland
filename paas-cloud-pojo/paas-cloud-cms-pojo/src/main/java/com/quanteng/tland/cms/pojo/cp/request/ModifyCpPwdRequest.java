/**
 * 文 件 名:  ModifyCpPwdRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/6/7
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.cp.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <修改Cp密码请求>
 *
 * @author LJun
 * @version 2018/6/7
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class ModifyCpPwdRequest extends BaseRequest
{
	/**
	 * cp编号
	 */
	private String cpId;
	/**
	 * 原密码
	 */
	private String password;
	/**
	 * 新密码
	 */
	private String newPassword;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("ModifyCpPwdRequest{");
		sb.append ("cpId='").append (cpId).append ('\'');
		sb.append (", password='").append (password).append ('\'');
		sb.append (", newPassword='").append (newPassword).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
