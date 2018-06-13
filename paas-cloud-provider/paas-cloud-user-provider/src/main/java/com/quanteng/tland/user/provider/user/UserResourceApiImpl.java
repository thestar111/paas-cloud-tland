/**
 * 文 件 名:  UserApiImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/12 0012
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.user.provider.user;

import com.google.common.collect.Lists;
import com.quanten.core.utils.Coder;
import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.common.encryption.EncryptCoder;
import com.quanteng.tland.common.thread.Language;
import com.quanteng.tland.user.api.user.UserResourceApi;
import com.quanteng.tland.user.database.entity.App;
import com.quanteng.tland.user.database.mapper.UserMapper;
import com.quanteng.tland.user.pojo.user.UserVo;
import com.quanteng.tland.user.pojo.user.domain.AppInfoVo;
import com.quanteng.tland.user.pojo.user.request.GetDownloadRecordRequest;
import com.quanteng.tland.user.pojo.user.request.QueryUserDownloadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.quanteng.tland.common.cons.Constants.Cons.DATA_LOCAL_LANGUAGE;
import static com.quanteng.tland.common.cons.Constants.Cons.DATA_PAGE_SIZE;
import static com.quanteng.tland.common.cons.Constants.Cons.DATA_PAGE_START;
import static com.quanteng.tland.common.log.TlandLogger.*;

/**
 * <用户资源接口实现>
 *
 * @author zping
 * @version 2018/4/12 0012
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class UserResourceApiImpl implements UserResourceApi
{
	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (UserResourceApiImpl.class);

	@Autowired
	private UserMapper userMapper;

	@Override
	public Result add (@RequestBody UserVo userVo) throws Exception
	{
		System.out.println (userVo.toString ());
		return new Result ().success ();
	}

	/**
	 * 查询用户下载历史记录(分区表)
	 *
	 * @param getDownloadRecordRequest
	 * @return
	 */
	@Override
	public Result<List<AppInfoVo>> getDownloadRecord (@RequestBody GetDownloadRecordRequest getDownloadRecordRequest)
	{
		i ("USER", "getDownloadRecord", LOG_TYPE_REQUEST, getDownloadRecordRequest);
		if (null == getDownloadRecordRequest)
		{
			return new Result<List<AppInfoVo>> ().failure ("getDownloadRecord request is null");
		}
		//构造数据库查询条件
		Map<String, Object> params = new HashMap<String, Object> ();
		if (! StringUtils.isEmpty (getDownloadRecordRequest.getMobileNumber ()))
		{
			params.put ("mobileNumber", getDownloadRecordRequest.getMobileNumber ());
		}
		params.put (DATA_LOCAL_LANGUAGE, Language.getLanguage ());
		params.put (DATA_PAGE_START,
				(getDownloadRecordRequest.getPageIndex () - 1) * getDownloadRecordRequest.getPageSize ());
		params.put (DATA_PAGE_SIZE, getDownloadRecordRequest.getPageSize ());
		//根据条件查询数据库
		List<App> appList = userMapper.getDownloadRecord (params);
		//定义返回结果集
		Result<List<AppInfoVo>> result = new Result<List<AppInfoVo>> ();
		List<AppInfoVo> appsVoList = Lists.newArrayList ();
		if (! CollectionUtils.isEmpty (appList))
		{
			AppInfoVo appsVo = null;
			for (App app : appList)
			{
				appsVo = new AppInfoVo ();
				BeanUtils.copyProperties (app, appsVo);
				appsVoList.add (appsVo);
			}

			result.setData (appsVoList);
			result.setTotalCount (userMapper.getDownloadRecordCount (params));
		}

		i ("USER", "getDownloadRecord", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 获取用户下载地址(两分钟有效)
	 *
	 * @param queryUserDownloadRequest
	 * @return
	 */
	@Override
	public Result<String> queryUserDownloadUrl (@RequestBody QueryUserDownloadRequest queryUserDownloadRequest)
	{
		if (null == queryUserDownloadRequest || StringUtils.isEmpty (queryUserDownloadRequest.getAppId ()))
		{
			return new Result<> ().failure ("illega params");
		}
		i ("USER", "queryUserDownloadUrl", LOG_TYPE_REQUEST, queryUserDownloadRequest);
		App app = userMapper.queryAppDownloadUrl (queryUserDownloadRequest.getAppId ());
		i ("USER", "queryUserDownloadUrl", LOG_TYPE_RESPONSE, app);
		String token = null;
		try
		{
			token = EncryptCoder.getInstance ().encrypt (
					String.format ("%s%s%s%s%s", app.getAppName (), ".apk|", System.currentTimeMillis (), "|/",
							app.getAppUrl ()));
			return new Result<> ().success (String.format ("%s%s", "storage/f/d/", token));
		}
		catch (Exception e)
		{
			return new Result<> ().failure ("Get Download failed.");
		}
	}
}
