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
package com.quanteng.tland.vas.provider.user;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.quanten.client.RedisClient;
import com.quanteng.tland.charging.pojo.order.domain.OrderVo;
import com.quanteng.tland.cms.pojo.app.domain.AppsVo;
import com.quanteng.tland.cms.pojo.app.request.QueryAppRequest;
import com.quanteng.tland.common.annotation.Api;
import com.quanteng.tland.common.cons.Constants;
import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.user.pojo.user.domain.AppInfoVo;
import com.quanteng.tland.user.pojo.user.request.GetDownloadRecordRequest;
import com.quanteng.tland.user.pojo.user.request.QueryUserDownloadRequest;
import com.quanteng.tland.vas.api.user.UserApi;
import com.quanteng.tland.vas.pojo.app.domain.AppDto;
import com.quanteng.tland.vas.pojo.user.domain.Order;
import com.quanteng.tland.vas.pojo.user.domain.Token;
import com.quanteng.tland.vas.pojo.user.request.*;
import com.quanteng.tland.vas.provider.component.AuthorizationTokenProvider;
import com.quanteng.tland.vas.service.app.AppService;
import com.quanteng.tland.vas.service.order.OrderService;
import com.quanteng.tland.vas.service.user.UserService;
import io.jsonwebtoken.Claims;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

import static com.quanteng.tland.common.cons.Constants.RedisKeyCons.MOBILE_VCODE_PREFIX;
import static com.quanteng.tland.common.log.TlandLogger.*;

/**
 * <用户接口API实现类>
 *
 * @author zping
 * @version 2018/4/12 0012
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Api
public class UserApiImpl implements UserApi
{

	@Autowired
	private UserService userService;

	@Autowired
	private AppService appService;

	@Autowired
	private RedisClient redisClient;

	@Autowired
	private AuthorizationTokenProvider authorizationTokenProvider;

	@Autowired
	private OrderService orderService;

	/**
	 * 获取用户短信验证码
	 * 供客户端用户登录时，根据手机号码获取短信验证码
	 *
	 * @param getVerifyCodeRequset
	 * @return
	 */
	@Override
	public Result getVerifyCode (GetVerifyCodeRequset getVerifyCodeRequset)
	{
		i ("USER", "getVerifyCode", LOG_TYPE_REQUEST, getVerifyCodeRequset);
		if (null == getVerifyCodeRequset)
		{
			return new Result ().failure ("getVerifyCode illegal params");
		}

		String verifyCode = String.valueOf ((int) ((Math.random () * 9 + 1) * 100000));

		//存入redis
		try
		{
			redisClient.set (MOBILE_VCODE_PREFIX + getVerifyCodeRequset.getMobileNumber (), verifyCode, "NX", "EX", 60);
		}
		catch (Exception e)
		{
			e ("USER", "getVerifyCode", e.getLocalizedMessage ());
			return new Result ().failure ("Get verify code failed.");
		}

		//TODO
		//发送验证码短信

		return new Result ().success ();
	}

	/**
	 * 用户登录
	 * 供客户端用户根据手机号码登录
	 *
	 * @param loginRequest
	 * @return
	 */
	@Override
	public Result<Token> login (LoginRequest loginRequest)
	{
		if (null == loginRequest)
		{
			return new Result ().failure ("login illegal params");
		}
		i ("USER", "login", LOG_TYPE_REQUEST, loginRequest);
		Token userToken = null;
		if (vwl (loginRequest.getMobileNumber ()) || vvc (loginRequest.getMobileNumber (), loginRequest.getCode ()))
		{
			//校验成功，生成TOKEN
			Map<String, Object> claims = Maps.newHashMap ();
			String token = authorizationTokenProvider.createAccessToken (claims, loginRequest.getMobileNumber ());
			String refreshToken = authorizationTokenProvider
					.createRefreshToken (claims, loginRequest.getMobileNumber ());
			userToken = new Token ();
			userToken.setToken (token);
			userToken.setRefreshToken (refreshToken);
		}
		else
		{
			return new Result<> ().failure ("login failed");
		}
		return new Result<> ().success (userToken);
	}

	/**
	 * 查询用户下载历史记录(分区表)
	 * 供客户端用户根据手机号码登录
	 *
	 * @param downloadRecordRequest
	 * @return
	 */
	@Override
	public Result<List<AppDto>> downloadRecord (DownloadRecordRequest downloadRecordRequest)
	{
		i ("USER", "downloadRecord", LOG_TYPE_REQUEST, downloadRecordRequest);
		if (null == downloadRecordRequest)
		{
			return new Result ().failure ("downloadRecord illegal params,request is null");
		}

		//构造user请求
		GetDownloadRecordRequest getDownloadRecordRequest = new GetDownloadRecordRequest ();
		getDownloadRecordRequest.setMobileNumber (downloadRecordRequest.getMobileNumber ());
		getDownloadRecordRequest.setMonth (downloadRecordRequest.getMonth ());
		//查询user
		Result<List<AppInfoVo>> serviceResult = userService.getDownloadRecord (getDownloadRecordRequest);
		//定义返回结果集
		Result<List<AppDto>> result = new Result<List<AppDto>> ();
		List<AppDto> appDtoList = Lists.newArrayList ();
		if (null != serviceResult && (Constants.ResultCode.SUCCESS).equals (serviceResult.getResultCode ()))
		{
			List<AppInfoVo> appInfoVoList = serviceResult.getData ();
			if (! CollectionUtils.isEmpty (appInfoVoList))
			{
				AppDto appDto = null;
				for (AppInfoVo appInfoVo : appInfoVoList)
				{
					appDto = new AppDto ();
					BeanUtils.copyProperties (appInfoVo, appDto);
					appDtoList.add (appDto);
				}
				result.setData (appDtoList);
				result.setTotalCount (serviceResult.getTotalCount ());
			}
		}
		else
		{
			result.setResultMessage ("downloadRecord CMSServcis Return Data Is Null Or ReturnCode No Zero");
		}
		i ("USER", "downloadRecord", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 猜你喜欢的游戏应用推荐
	 * 游戏详情页，下载管理页中的猜你喜欢游戏应用推荐接口
	 *
	 * @param getRecommandAppRequest
	 * @return
	 */
	@Override
	public Result<List<AppDto>> appRecommand (GetRecommandAppRequest getRecommandAppRequest)
	{
		i ("USER", "RecommandApp", LOG_TYPE_REQUEST, getRecommandAppRequest);
		if (null == getRecommandAppRequest)
		{
			return new Result ().failure ("RecommandApp illegal params");
		}
		//构造cms请求
		QueryAppRequest queryAppRequest = new QueryAppRequest ();
		queryAppRequest.setCatalogId (getRecommandAppRequest.getCatalogId ());
		queryAppRequest.setAppId (getRecommandAppRequest.getAppId ());
		queryAppRequest.setPageIndex (getRecommandAppRequest.getPageIndex ());
		queryAppRequest.setPageSize (getRecommandAppRequest.getPageSize ());
		//查询cms
		Result<List<AppsVo>> serviceResult = appService.guessAppRecommand (queryAppRequest);
		//定义返回结果集
		Result<List<AppDto>> result = new Result<List<AppDto>> ();
		List<AppDto> appDtoList = Lists.newArrayList ();
		if (null != serviceResult && (Constants.ResultCode.SUCCESS).equals (serviceResult.getResultCode ()))
		{
			List<AppsVo> appsVoList = serviceResult.getData ();
			if (! CollectionUtils.isEmpty (appsVoList))
			{
				AppDto appDto = null;
				for (AppsVo appsVo : appsVoList)
				{
					appDto = new AppDto ();
					BeanUtils.copyProperties (appsVo, appDto);
					appDtoList.add (appDto);
				}
				result.setData (appDtoList);
				result.setTotalCount (serviceResult.getTotalCount ());
			}
		}
		else
		{
			result.setResultMessage ("RecommandApp CMSServcis Return Data Is Null Or ReturnCode No Zero");
		}
		i ("USER", "RecommandApp", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 获取用户Token
	 *
	 * @param getAccessTokenRequest
	 * @return
	 */
	@Override
	public Result<Token> getAccessToken (GetAccessTokenRequest getAccessTokenRequest)
	{
		i ("USER", "getAccessToken", LOG_TYPE_REQUEST, getAccessTokenRequest);
		if (null == getAccessTokenRequest || StringUtils.isEmpty (getAccessTokenRequest.getRefreshToken ()))
		{
			return new Result ().failure ("getAccessToken illegal params");
		}
		Claims claims = null;

		try
		{
			//解析token
			claims = authorizationTokenProvider.parseToken (getAccessTokenRequest.getRefreshToken ());
		}
		catch (Exception e)
		{
			e ("USER", "getAccessToken", "parseToken Exception!");
			return new Result ().failure ("parseToken Exception!");
		}
		//定义返回结果集
		Result<Token> result = new Result<Token> ();
		if (! StringUtils.isEmpty (claims))
		{
			Map<String, Object> newClaims = Maps.newHashMap ();
			Token token = new Token ();
			String tokenTemp = authorizationTokenProvider.createAccessToken (newClaims, claims.getSubject ());
			String refreshToken = authorizationTokenProvider.createRefreshToken (newClaims, claims.getSubject ());
			token.setRefreshToken (refreshToken);
			token.setToken (tokenTemp);
			result.setData (token);
		}

		i ("USER", "getAccessToken", LOG_TYPE_RESPONSE, result);
		return result;
	}

	/**
	 * 根据用户账号获取应用下载地址接口
	 *
	 * @param getAppDownload
	 * @return
	 */
	@Override
	public Result<String> getAppDownload (GetAppDownloadRequest getAppDownload)
	{
		if (null == getAppDownload)
		{
			return new Result ().failure ("getAppDownload illegal params");
		}
		i ("USER", "getAppDownload", LOG_TYPE_REQUEST, getAppDownload);

		//TODO 校验用户订购关系

		QueryUserDownloadRequest queryUserDownloadRequest = new QueryUserDownloadRequest ();
		queryUserDownloadRequest.setAppId (getAppDownload.getAppId ());
		queryUserDownloadRequest.setUserId (getAppDownload.getAccount ());
		i ("USER", "getAppDownload", LOG_TYPE_RESPONSE, queryUserDownloadRequest);
		Result<String> result = userService.queryUserDownloadUrl (queryUserDownloadRequest);
		i ("USER", "getAppDownload", LOG_TYPE_RESPONSE, result);

		return result;
	}

	/**
	 * 查询用户生效的订购套餐
	 *
	 * @param queryUserOrderRequest
	 * @return
	 */
	@Override
	public Result<Order> queryUserOrder (QueryUserOrderRequest queryUserOrderRequest)
	{
		if (StringUtils.isEmpty (queryUserOrderRequest.getAccount ()))
		{
			return new Result<> ().failure ("account is null");
		}
		i ("USER", "queryUserOrder", LOG_TYPE_REQUEST, queryUserOrderRequest);
		Result<OrderVo> orderVoResult = orderService.queryEffectiveOrder (queryUserOrderRequest.getAccount ());
		i ("USER", "queryUserOrder", LOG_TYPE_RESPONSE, orderVoResult);
		if (Constants.ResultCode.SUCCESS.equals (orderVoResult.getResultCode ()))
		{
			Order order = null;
			if (null != orderVoResult.getData ())
			{
				OrderVo orderVo = orderVoResult.getData ();
				order = new Order ();
				order.setAccountId (orderVo.getAccountId ());
				order.setStartTime (orderVo.getStartTime ());
				order.setEndTime (orderVo.getEndTime ());
				order.setPackageId (orderVo.getPackageId ());
				order.setStatus (orderVo.getStatus ());
			}
			return new Result<> ().success (order);
		}
		else
		{
			return new Result<> ().failure ("request failed.");
		}
	}

	/**
	 * 根据用户账号验证验证码
	 *
	 * @param account
	 * @param code
	 * @return
	 */
	private boolean vvc (String account, String code)
	{
		boolean flag = false;
		String verifyCode = null;

		try
		{
			//获取redis中的验证码
			verifyCode = (String) redisClient.get (MOBILE_VCODE_PREFIX + account, String.class);
		}
		catch (Exception e)
		{
			e ("USER", "login", "GetVerifyCode in Redis Error");
			return flag;
		}

		//校验验证码
		if (verifyCode.equals (code))
		{
			flag = true;
		}
		else
		{
			e ("USER", "login", "The verification code has expired or not exist");
		}

		return flag;
	}

	/**
	 * 校验白名单
	 *
	 * @param phone
	 * @return
	 */
	private boolean vwl (String phone)
	{
		if ("254151139912".equals (phone))
		{
			return true;
		}
		return false;
	}
}
