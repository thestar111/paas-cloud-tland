/**
 * 文 件 名:  GetDownloadRecordRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/22
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.user.pojo.user.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <获取用户历史下载记录请求>
 *
 * @author LJun
 * @version 2018/5/22
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class GetDownloadRecordRequest extends BasePageRequest
{
	/**
	 * 用户手机号
	 */
	private String mobileNumber;
	/**
	 * 月份
	 */
	private String month;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("GetDownloadRecordRequest{");
		sb.append ("mobileNumber='").append (mobileNumber).append ('\'');
		sb.append (", month='").append (month).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
