/**
 * 文 件 名:  Admins
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huangsongbo
 * 修改时间:  2017/8/8
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.admin.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <系统管理员信息>
 *
 * @author huangsongbo
 * @version 2017/8/8
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AdminVo implements Serializable
{
	/**
	 * 管理员id
	 */
	private String adminId;

	/**
	 * 管理员名字
	 */
	private String adminName;

	/**
	 * 管理员密码
	 */
	private String password;

	/**
	 * 英文名字
	 */
	private String englishName;

	/**
	 * 管理员账号
	 */
	private String adminAccount;

	/**
	 * 管理员家庭地址
	 */
	private String homeAddr;

	/**
	 * 管理员出生日期 yyyy-MM-dd HH:mm:ss
	 */
	private String birthday;

	/**
	 * 管理员性别
	 */
	private Integer sex;

	/**
	 * 管理员电话号码
	 */
	private String tel;

	/**
	 * 管理员状态（暂时不用）
	 */
	private String status;

	/**
	 * 管理员邮箱
	 */
	private String email;

	/**
	 * 管理员创建时间
	 */
	private String createTime;

	/**
	 * 管理员最后一次修改时间
	 */
	private String lastUpdateTime;

	/**
	 * 管理员类型
	 * 0：渠道方员工
	 * 1：CP方员工
	 * 2：开发人员
	 */
	private String userType;

	/**
	 * 当userType为1时必填，管理员所属合作伙伴id
	 */
	private String cpId;

	/**
	 * 当userType为0时必填，管理员所属渠道id
	 */
	private String channel;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("Admins{");
		sb.append ("adminId='").append (adminId).append ('\'');
		sb.append (", adminName='").append (adminName).append ('\'');
		sb.append (", password='").append (password).append ('\'');
		sb.append (", englishName='").append (englishName).append ('\'');
		sb.append (", adminAccount='").append (adminAccount).append ('\'');
		sb.append (", homeAddr='").append (homeAddr).append ('\'');
		sb.append (", birthday='").append (birthday).append ('\'');
		sb.append (", sex=").append (sex);
		sb.append (", tel='").append (tel).append ('\'');
		sb.append (", status='").append (status).append ('\'');
		sb.append (", email='").append (email).append ('\'');
		sb.append (", createTime='").append (createTime).append ('\'');
		sb.append (", lastUpdateTime='").append (lastUpdateTime).append ('\'');
		sb.append (", userType='").append (userType).append ('\'');
		sb.append (", cpId='").append (cpId).append ('\'');
		sb.append (", channel='").append (channel).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
