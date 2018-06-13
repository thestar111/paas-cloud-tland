/**
 * 文 件 名:  Token
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.user.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/5/22 0022
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class Token implements Serializable
{
	/**
	 * 用户信息Token
	 */
	private String token;
	/**
	 * 用户刷新Token
	 */
	private String refreshToken;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("Token{");
		sb.append ("token='").append (token).append ('\'');
		sb.append (", refreshToken='").append (refreshToken).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
