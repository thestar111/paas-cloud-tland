/**
 * 文 件 名:  CatalogLangVo
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/2 0002
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.catalog.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <栏目多语言信息>
 *
 * @author zping
 * @version 2018/5/2 0002
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class CatalogLangVo implements Serializable
{
	/**
	 * 业务编号
	 */
	private Integer id;

	/**
	 * 栏目编号
	 */
	private String catalogId;
	/**
	 * 名称
	 */
	private String catalogName;
	/**
	 * 描述
	 */
	private String catalogDesc;
	/**
	 * 语言
	 */
	private String local;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("CatalogLangVo{");
		sb.append ("id=").append (id);
		sb.append (", catalogId='").append (catalogId).append ('\'');
		sb.append (", catalogName='").append (catalogName).append ('\'');
		sb.append (", catalogDesc='").append (catalogDesc).append ('\'');
		sb.append (", local='").append (local).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
