/**
 * 文 件 名:  LoginRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.user.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <用户登录请求>
 *
 * @author LJun
 * @version 2018/5/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class LoginRequest extends BaseRequest
{
	/**
	 * 用户手机号码
	 */
	private String mobileNumber;

	/**
	 * 短信验证码
	 */
	private String code;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("LoginRequest{");
		sb.append ("mobileNumber='").append (mobileNumber).append ('\'');
		sb.append (", code='").append (code).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
