/**
 * 文 件 名:  User
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/10 0010
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <用户实体>
 *
 * @author zping
 * @version 2017/7/10 0010
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class User extends BaseObject
{
	/**
	 * 用户账号
	 */
	private String accountId;
	/**
	 * 用户名称
	 */
	private String accountName;
	/**
	 * 用户图标
	 */
	private String accountIcon;
	/**
	 * 注册时间
	 */
	private String registerTime;
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
		final StringBuilder sb = new StringBuilder ("User{");
		sb.append ("accountId='").append (accountId).append ('\'');
		sb.append (", accountName='").append (accountName).append ('\'');
		sb.append (", accountIcon='").append (accountIcon).append ('\'');
		sb.append (", registerTime='").append (registerTime).append ('\'');
		sb.append (", password='").append (password).append ('\'');
		sb.append (", channel='").append (channel).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
