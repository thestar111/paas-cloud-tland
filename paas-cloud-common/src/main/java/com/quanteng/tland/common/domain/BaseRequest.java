/**
 * 文 件 名:  BaseRequest
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/18 0018
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.common.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/18 0018
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class BaseRequest implements Serializable
{
	/**
	 * 语言字段
	 */
	private String language;

	private Map<String, Object> exts = null;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("BaseRequest{");
		sb.append ("language='").append (language).append ('\'');
		sb.append (", exts=").append (exts);
		sb.append ('}');
		return sb.toString ();
	}
}
