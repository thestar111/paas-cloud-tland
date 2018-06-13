/**
 * 文 件 名:  ChannelResourceImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/4 0004
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.channel;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.quanteng.tland.cms.api.channel.ChannelResource;
import com.quanteng.tland.cms.database.entity.Channel;
import com.quanteng.tland.cms.database.mapper.ChannelMapper;
import com.quanteng.tland.cms.pojo.channel.domain.ChannelVo;
import com.quanteng.tland.cms.pojo.channel.request.AddChannelRequest;
import com.quanteng.tland.cms.pojo.channel.request.QueryChannelListRequest;
import com.quanteng.tland.cms.pojo.channel.request.UpdateChannelRequest;
import com.quanteng.tland.common.domain.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.quanteng.tland.common.cons.Constants.Cons.DATA_PAGE_SIZE;
import static com.quanteng.tland.common.cons.Constants.Cons.DATA_PAGE_START;
import static com.quanteng.tland.common.log.TlandLogger.*;

/**
 * <渠道资源接口实现>
 *
 * @author zping
 * @version 2018/5/4 0004
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class ChannelResourceImpl implements ChannelResource
{

	@Autowired
	private ChannelMapper channelMapper;

	/**
	 * 新增渠道
	 *
	 * @param addChannelRequest
	 * @return
	 */
	@Override
	public Result<String> addChannel (@RequestBody AddChannelRequest addChannelRequest)
	{
		if (null == addChannelRequest || null == addChannelRequest.getChannel ())
		{
			return new Result<> ().failure ("illega params.");
		}
		Channel channel = new Channel ();
		ChannelVo channelVo = addChannelRequest.getChannel ();
		BeanUtils.copyProperties (channelVo, channel);
		i ("CHANNEL", "addChannel", LOG_TYPE_REQUEST, addChannelRequest);
		int flag = channelMapper.addChannel (channel);
		i ("CHANNEL", "addChannel", LOG_TYPE_RESPONSE, flag);
		if (0 < flag)
		{
			return new Result<> ().success ();
		}
		else
		{
			return new Result<> ().failure ("add channel failed.");
		}
	}

	/**
	 * 更新渠道
	 *
	 * @param updateChannelRequest
	 * @return
	 */
	@Override
	public Result<String> updateChannel (@RequestBody UpdateChannelRequest updateChannelRequest)
	{
		if (null == updateChannelRequest || null == updateChannelRequest.getChannel ())
		{
			return new Result<> ().failure ("illega params.");
		}
		Channel channel = new Channel ();
		ChannelVo channelVo = updateChannelRequest.getChannel ();
		BeanUtils.copyProperties (channelVo, channel);
		i ("CHANNEL", "updateChannel", LOG_TYPE_REQUEST, updateChannelRequest);
		int flag = channelMapper.updateChannel (channel);
		i ("CHANNEL", "updateChannel", LOG_TYPE_RESPONSE, flag);

		if (0 < flag)
		{
			return new Result<> ().success ();
		}
		else
		{
			return new Result<> ().failure ("modify channel failed.");
		}
	}

	/**
	 * 根据Id查询渠道信息
	 *
	 * @param channelId
	 * @return
	 */
	@Override
	public Result<ChannelVo> queryChannelById (@PathVariable ("channel") String channelId)
	{
		if (StringUtils.isEmpty (channelId))
		{
			return new Result<> ().failure ("channelId illega params.");
		}
		i ("CHANNEL", "queryChannelById", LOG_TYPE_REQUEST, channelId);
		Channel channel = channelMapper.queryChannelById (channelId);
		i ("CHANNEL", "queryChannelById", LOG_TYPE_RESPONSE, channel);
		ChannelVo channelVo = null;
		if (null != channel)
		{
			channelVo = new ChannelVo ();
			BeanUtils.copyProperties (channel, channelVo);
		}
		return new Result<> ().success (channelVo);
	}

	/**
	 * 查询渠道信息列表
	 *
	 * @param queryChannelListRequest
	 * @return
	 */
	@Override
	public Result<List<ChannelVo>> queryChannelList (@RequestBody QueryChannelListRequest queryChannelListRequest)
	{
		Map<String, Object> params = Maps.newHashMap ();

		if (! StringUtils.isEmpty (queryChannelListRequest.getChannelName ()))
		{
			params.put ("channelName", queryChannelListRequest.getChannelName ());
		}

		if (! StringUtils.isEmpty (queryChannelListRequest.getLinkType ()))
		{
			params.put ("linkType", queryChannelListRequest.getLinkType ());
		}

		params.put (DATA_PAGE_START,
				(queryChannelListRequest.getPageIndex () - 1) * queryChannelListRequest.getPageSize ());
		params.put (DATA_PAGE_SIZE, queryChannelListRequest.getPageSize ());
		i ("CHANNEL", "queryChannelList", LOG_TYPE_REQUEST, params);
		List<Channel> channels = channelMapper.queryChannelList (params);
		i ("CHANNEL", "queryChannelList", LOG_TYPE_RESPONSE, channels);

		//定义返回结果集
		Result<List<ChannelVo>> result = new Result<List<ChannelVo>> ();
		List<ChannelVo> channelVos = null;
		if (! CollectionUtils.isEmpty (channels))
		{
			channelVos = Lists.newArrayList ();
			ChannelVo channelVo = null;

			for (Channel channel : channels)
			{
				channelVo = new ChannelVo ();
				BeanUtils.copyProperties (channel, channelVo);
				channelVos.add (channelVo);
			}
			result.setData (channelVos);
			result.setTotalCount (channelMapper.queryCountChannel (params));
		}
		return result;
	}

	/**
	 * 删除渠道信息
	 *
	 * @param channelId
	 * @return
	 */
	@Override
	public Result<String> deleteChannel (@PathVariable ("channel") String channelId)
	{
		if (StringUtils.isEmpty (channelId))
		{
			return new Result<> ().failure ("channelId illega params.");
		}
		i ("CHANNEL", "deleteChannel", LOG_TYPE_REQUEST, channelId);
		int flag = channelMapper.deleteChannel (channelId);
		i ("CHANNEL", "deleteChannel", LOG_TYPE_RESPONSE, flag);
		if (0 < flag)
		{
			return new Result<> ().success ();
		}
		else
		{
			return new Result<> ().failure ("delete channel failed.");
		}
	}
}
