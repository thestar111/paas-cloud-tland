/**
 * 文 件 名:  ResetPwdRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/28
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.cp.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * CP重置密码请求
 *
 * @author LJun
 * @version 2018/5/28
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class ResetPwdRequest extends BaseRequest
{
	/**
	 * cp编号
	 */
	private String cpId;
	/**
	 * 密码
	 */
	private String password;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("ResetPwdRequest{");
		sb.append ("cpId='").append (cpId).append ('\'');
		sb.append (", password='").append (password).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
