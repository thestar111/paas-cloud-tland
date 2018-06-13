/**
 * 文 件 名:  QueryUserDownloadRequest
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/6/4 0004
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.user.pojo.user.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/6/4 0004
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryUserDownloadRequest extends BaseRequest
{

	/**
	 * 用户账号
	 */
	private String userId;

	/**
	 * 应用编号
	 */
	private String appId;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QueryUserDownloadRequest{");
		sb.append ("userId='").append (userId).append ('\'');
		sb.append (", appId='").append (appId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
