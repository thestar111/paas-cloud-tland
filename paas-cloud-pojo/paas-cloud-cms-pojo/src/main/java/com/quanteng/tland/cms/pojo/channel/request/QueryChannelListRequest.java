/**
 * 文 件 名:  QueryChannelListRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2017/11/13
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.channel.request;

import com.quanteng.tland.common.domain.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * 查询渠道信息列表请求
 *
 * @author LJun
 * @version 2017/11/13
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QueryChannelListRequest extends BasePageRequest
{
	/**
	 * 渠道名称
	 **/
	private String channelName;
	/**
	 * 链接类型
	 **/
	private String linkType;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QueryChannelListRequest{");
		sb.append (", channelName='").append (channelName).append ('\'');
		sb.append (", linkType='").append (linkType).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
