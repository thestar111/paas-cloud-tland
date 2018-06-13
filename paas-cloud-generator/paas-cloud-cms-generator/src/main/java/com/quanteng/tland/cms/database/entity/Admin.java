/**
 * 文 件 名:  Admin
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.database.entity;

import com.quanteng.tland.common.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <管理员>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class Admin extends BaseObject
{
	/**
	 * 管理员编号
	 */
	private String adminId;
	/**
	 * 管理员名称
	 */
	private String adminName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 英文名称
	 */
	private String englishName;
	/**
	 * 管理员账号
	 */
	private String adminAccount;
	/**
	 * 家庭地址
	 */
	private String homeAddr;
	/**
	 * 生日
	 */
	private String birthday;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 最后更新时间
	 */
	private String lastUpdateTime;
	/**
	 * 类型
	 */
	private String userType;
	/**
	 * CP编号
	 */
	private String cpId;
	/**
	 * 渠道
	 */
	private String channel;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("Admin{");
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
		sb.append (", createTime=").append (createTime);
		sb.append (", lastUpdateTime=").append (lastUpdateTime);
		sb.append (", userType='").append (userType).append ('\'');
		sb.append (", cpId='").append (cpId).append ('\'');
		sb.append (", channel='").append (channel).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
