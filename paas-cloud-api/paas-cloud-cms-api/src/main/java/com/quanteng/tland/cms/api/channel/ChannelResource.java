/**
 * 文 件 名:  ChannelResource
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:   LJun
 * 修改时间:  2017/11/13
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.api.channel;

/**
 * 渠道管理接口
 *
 * @author LJun
 * @version 2017/11/13
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

import com.quanteng.tland.cms.pojo.channel.domain.ChannelVo;
import com.quanteng.tland.cms.pojo.channel.request.AddChannelRequest;
import com.quanteng.tland.cms.pojo.channel.request.QueryChannelListRequest;
import com.quanteng.tland.cms.pojo.channel.request.UpdateChannelRequest;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping ("/cms/channel")
public interface ChannelResource
{
	/**
	 * 新增渠道
	 *
	 * @param addChannelRequest
	 * @return
	 */
	@RequestMapping (value = "/addChannel", method = RequestMethod.POST)
	Result<String> addChannel (@RequestBody AddChannelRequest addChannelRequest);

	/**
	 * 更新渠道
	 *
	 * @param updateChannelRequest
	 * @return
	 */
	@RequestMapping (value = "/modify", method = RequestMethod.PUT)
	Result<String> updateChannel (@RequestBody UpdateChannelRequest updateChannelRequest);

	/**
	 * 根据Id查询渠道信息
	 *
	 * @param channelId
	 * @return
	 */
	@RequestMapping (value = "/id/{channel}", method = RequestMethod.GET)
	Result<ChannelVo> queryChannelById (@PathVariable ("channel") String channelId);

	/**
	 * 查询渠道信息列表
	 *
	 * @param queryChannelListRequest
	 * @return
	 */
	@RequestMapping (value = "/queryChannelList", method = RequestMethod.POST)
	Result<List<ChannelVo>> queryChannelList (@RequestBody QueryChannelListRequest queryChannelListRequest);

	/**
	 * 删除渠道信息
	 *
	 * @param channelId
	 * @return
	 */
	@RequestMapping (value = "/delete/{channel}", method = RequestMethod.DELETE)
	Result<String> deleteChannel (@PathVariable ("channel") String channelId);
}
