/**
 * 文 件 名:  GetAccessTokenRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/23
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.user.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <刷新用户token请求>
 *
 * @author LJun
 * @version 2018/5/23
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class GetAccessTokenRequest extends BaseRequest
{
	/**
	 * 访问刷新的Token
	 */
	private String refreshToken;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("GetAccessTokenRequest{");
		sb.append ("refreshToken='").append (refreshToken).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
