/**
 * 文 件 名:  FindAppByIdRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/14
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.app.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * 根据ID查询应用请求  供客户端使用
 *
 * @author LJun
 * @version 2018/5/14
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class FindAppByIdRequest extends BaseRequest
{
	/**
	 * 应用编号
	 */
	private String appId;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("FindAppByIdRequest{");
		sb.append ("appId='").append (appId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
