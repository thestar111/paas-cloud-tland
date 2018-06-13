/**
 * 文 件 名:  SearchAppByNameRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/21
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.app.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <根据应用名称搜索请求>
 *
 * @author LJun
 * @version 2018/5/21
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class SearchAppByNameRequest extends BasePageRequest
{
	/**
	 * appName
	 */
	private String appName;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("SearchAppByNameRequest{");
		sb.append ("appName='").append (appName).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
