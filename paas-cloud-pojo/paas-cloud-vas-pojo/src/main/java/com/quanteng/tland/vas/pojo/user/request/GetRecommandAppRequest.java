/**
 * 文 件 名:  GetRecommandAppRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/21
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.user.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author LJun
 * @version 2018/5/21
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class GetRecommandAppRequest extends BasePageRequest
{

	/**
	 * 应用分类编号
	 */
	private String catalogId;
	/**
	 * 当前应用编号
	 */
	private String appId;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("GetRecommandAppRequest{");
		sb.append ("catalogId='").append (catalogId).append ('\'');
		sb.append (", appId='").append (appId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
