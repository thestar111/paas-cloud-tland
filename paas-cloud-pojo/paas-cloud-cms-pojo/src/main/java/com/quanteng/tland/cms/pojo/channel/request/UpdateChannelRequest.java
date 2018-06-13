/**
 * 文 件 名:  UpdateChannelRequest
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2017/11/13
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.channel.request;

import com.quanteng.tland.cms.pojo.channel.domain.ChannelVo;
import com.quanteng.tland.common.domain.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * 更新渠道信息请求
 *
 * @author LJun
 * @version 2017/11/13
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class UpdateChannelRequest extends BaseRequest
{
	/**
	 * 渠道信息模型
	 **/
	private ChannelVo channel;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("UpdateChannelRequest{");
		sb.append ("channelBean=").append (channel);
		sb.append ('}');
		return sb.toString ();
	}
}
