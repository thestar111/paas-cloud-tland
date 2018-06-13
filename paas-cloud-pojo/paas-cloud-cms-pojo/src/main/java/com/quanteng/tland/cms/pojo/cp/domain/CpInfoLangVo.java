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
 * <CP多语言信息>
 *
 * @author huangsongbo
 * @version 2017/8/23
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class CpInfoLangVo implements Serializable
{
	/**
	 * 业务编号
	 */
	private Integer id;
	/**
	 * CP编号
	 */
	private String cpId;
	/**
	 * cp名称
	 */
	private String cpName;
	/**
	 * 备注
	 */
	private String memo;

	/**
	 * 语言
	 */
	private String local;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("CpInfoLangVo{");
		sb.append ("id=").append (id);
		sb.append (", cpId='").append (cpId).append ('\'');
		sb.append (", cpName='").append (cpName).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append (", local='").append (local).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
