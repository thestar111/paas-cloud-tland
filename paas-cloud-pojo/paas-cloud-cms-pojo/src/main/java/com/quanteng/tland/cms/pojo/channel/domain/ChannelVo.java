/**
 * 文 件 名:  ChannelBean
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2017/11/13
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.pojo.channel.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 渠道信息实体
 *
 * @author LJun
 * @version 2017/11/13
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Setter
@Getter
public class ChannelVo implements Serializable
{
	/**
	 * 主键标识自增长
	 **/
	private String id;
	/**
	 * 渠道标识
	 **/
	private String channelId;
	/**
	 * 渠道名称
	 **/
	private String channelName;
	/**
	 * 链接类型 0首页，1栏目，2应用
	 **/
	private String linkType;
	/**
	 * 链接地址
	 **/
	private String linkAddress;
	/**
	 * 栏目ID 链接类型为栏目时必填
	 **/
	private String catalogId;
	/**
	 * 应用名称 链接类型为应用是必填
	 **/
	private String appName;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("ChannelVo{");
		sb.append ("id='").append (id).append ('\'');
		sb.append (", channelId='").append (channelId).append ('\'');
		sb.append (", channelName='").append (channelName).append ('\'');
		sb.append (", linkType='").append (linkType).append ('\'');
		sb.append (", linkAddress='").append (linkAddress).append ('\'');
		sb.append (", catalogId='").append (catalogId).append ('\'');
		sb.append (", appName='").append (appName).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
