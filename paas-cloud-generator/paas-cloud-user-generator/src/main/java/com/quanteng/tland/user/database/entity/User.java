/**
 * 文 件 名:  User
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/12 0012
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.user.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/12 0012
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class User extends BaseObject
{
	/**
	 * 账号
	 */
	private String accountId;

	/**
	 * 用户名称
	 */
	private String accountName;

	/**
	 * 头像地址
	 */
	private String accountIcon;

	/**
	 * 注册时间
	 */
	private String createTime;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 渠道
	 */
	private String channel;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("User{");
		sb.append ("accountId='").append (accountId).append ('\'');
		sb.append (", accountName='").append (accountName).append ('\'');
		sb.append (", accountIcon='").append (accountIcon).append ('\'');
		sb.append (", createTime='").append (createTime).append ('\'');
		sb.append (", password='").append (password).append ('\'');
		sb.append (", channel='").append (channel).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
