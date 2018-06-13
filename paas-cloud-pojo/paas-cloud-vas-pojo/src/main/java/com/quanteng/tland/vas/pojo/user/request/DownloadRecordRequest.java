/**
 * 文 件 名:  DownloadRecordRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/16
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.pojo.user.request;

import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <查询用户下载记录请求>
 *
 * @author LJun
 * @version 2018/5/16
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class DownloadRecordRequest extends BaseRequest
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
		final StringBuffer sb = new StringBuffer ("DownloadRecordRequest{");
		sb.append ("mobileNumber='").append (mobileNumber).append ('\'');
		sb.append (", month='").append (month).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
