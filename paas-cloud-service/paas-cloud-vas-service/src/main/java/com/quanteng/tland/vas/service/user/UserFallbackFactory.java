/**
 * 文 件 名:  UserFallbackFactory
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/9 0009
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.service.user;

import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.user.pojo.user.UserVo;
import com.quanteng.tland.user.pojo.user.domain.AppInfoVo;
import com.quanteng.tland.user.pojo.user.request.GetDownloadRecordRequest;
import com.quanteng.tland.user.pojo.user.request.QueryUserDownloadRequest;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <用户服务熔断降级>
 *
 * @author zping
 * @version 2018/4/9 0009
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class UserFallbackFactory implements FallbackFactory<UserService>
{

	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (UserFallbackFactory.class);

	@Override
	public UserService create (Throwable throwable)
	{

		LOGGER.error (String.format ("User Service Not Available : %s", throwable.getMessage ()));
		return new UserService ()
		{
			@Override
			public Result add (UserVo userVo) throws Exception
			{
				return new Result ().failure ("User Service not Available");
			}

			@Override
			public Result<List<AppInfoVo>> getDownloadRecord (GetDownloadRecordRequest getDownloadRecordRequest)
			{
				return new Result ().failure ("User Service not Available");
			}

			/**
			 * 获取用户下载地址
			 *
			 * @param queryUserDownloadRequest
			 * @return
			 */
			@Override
			public Result<String> queryUserDownloadUrl (QueryUserDownloadRequest queryUserDownloadRequest)
			{
				return new Result ().failure ("User Service not Available");
			}
		};

	}
}
