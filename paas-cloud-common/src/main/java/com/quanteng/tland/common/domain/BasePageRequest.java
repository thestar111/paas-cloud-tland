/**
 * 文 件 名:  BaseRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  chenJian
 * 修改时间:  2017/8/24
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.common.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author chenJian
 * @version 2017/8/24
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class BasePageRequest extends BaseRequest
{
	/**
	 * 页面开始索引
	 */
	private Integer pageIndex = 1;

	/**
	 * 显示大小
	 */
	private Integer pageSize = 10;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("BaseRequest{");
		sb.append ("pageIndex=").append (pageIndex);
		sb.append (", pageSize=").append (pageSize);
		sb.append ('}');
		return sb.toString ();
	}
}