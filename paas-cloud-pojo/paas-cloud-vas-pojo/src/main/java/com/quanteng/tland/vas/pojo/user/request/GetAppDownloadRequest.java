/**
 * 文 件 名:  GetAppDownloadRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/21
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.user.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <根据用户账号获取应用下载地址接口请求>
 *
 * @author LJun
 * @version 2018/5/21
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class GetAppDownloadRequest extends BaseRequest
{
	/**
	 * 用户帐号
	 */
	private String account;
	/**
	 * 应用编号(非必选)
	 */
	private String appId;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("GetAppDownloadRequest{");
		sb.append ("account='").append (account).append ('\'');
		sb.append (", appId='").append (appId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
