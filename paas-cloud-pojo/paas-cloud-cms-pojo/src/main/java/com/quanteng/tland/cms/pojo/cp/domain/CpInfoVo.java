/**
 * 文 件 名:  CpInfo
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  huangsongbo
 * 修改时间:  2017/8/23
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.cp.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <合作伙伴实体>
 *
 * @author huangsongbo
 * @version 2017/8/23
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class CpInfoVo implements Serializable
{
	/**
	 * 业务编号
	 */
	private String cpId;
	/**
	 * 父cpId
	 */
	private String parentCpId;
	/**
	 * cp名称
	 */
	private String cpName;
	/**
	 * 帐号
	 */
	private String account;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 0：正常 1：不可用
	 */
	private String cpStatus;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 管理员电话号码
	 */
	private String tel;
	/**
	 * 最后一次修改时间
	 */
	private String lastUpdateTime;
	/**
	 * 用户类型(1 : 合作伙伴用户  2 : 管理员用户)
	 */
	private Integer type;
	/**
	 * 所属渠道
	 */
	private String channel;
	/**
	 * 多语言信息
	 */
	private List<CpInfoLangVo> cpInfoLangs;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("CpInfoVo{");
		sb.append ("cpId='").append (cpId).append ('\'');
		sb.append (", parentCpId='").append (parentCpId).append ('\'');
		sb.append (", cpName='").append (cpName).append ('\'');
		sb.append (", account='").append (account).append ('\'');
		sb.append (", password='").append (password).append ('\'');
		sb.append (", createTime='").append (createTime).append ('\'');
		sb.append (", cpStatus='").append (cpStatus).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append (", tel='").append (tel).append ('\'');
		sb.append (", lastUpdateTime='").append (lastUpdateTime).append ('\'');
		sb.append (", type='").append (type).append ('\'');
		sb.append (", channel='").append (channel).append ('\'');
		sb.append (", cpInfoLangs=").append (cpInfoLangs);
		sb.append ('}');
		return sb.toString ();
	}
}
