/**
 * 文 件 名:  LocalLanguage
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.setting.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <多语言实体>
 *
 * @author LJun
 * @version 2018/5/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class LocalLanguage implements Serializable
{
	/**
	 * 业务编号
	 */
	private String localId;
	/**
	 * 国际语言标签名称
	 */
	private String localName;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("LocalLanguage{");
		sb.append ("localId='").append (localId).append ('\'');
		sb.append (", localName='").append (localName).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
