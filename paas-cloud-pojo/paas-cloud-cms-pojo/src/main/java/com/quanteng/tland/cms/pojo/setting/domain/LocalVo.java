/**
 * 文 件 名:  LocalVo
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2018/5/18
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.setting.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <国际语言信息>
 *
 * @author zhengbinggui
 * @version 2018/5/18
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class LocalVo implements Serializable
{
	/**
	 * 语言编号
	 */
	private String localId;

	/**
	 * 国际语言标签名称
	 */
	private String localName;

	/**
	 * 国家图标地址
	 */
	private String country;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("LocalVo{");
		sb.append ("localId='").append (localId).append ('\'');
		sb.append (", localName='").append (localName).append ('\'');
		sb.append (", country='").append (country).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
