/**
 * 文 件 名:  UserApi
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/12 0012
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.api.user;

import com.quanteng.tland.common.domain.Result;
import com.quanteng.tland.vas.pojo.app.domain.AppDto;
import com.quanteng.tland.vas.pojo.user.domain.Order;
import com.quanteng.tland.vas.pojo.user.domain.Token;
import com.quanteng.tland.vas.pojo.user.request.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/12 0012
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Path ("/user")
public interface UserApi
{
	/**
	 * 获取用户短信验证码
	 * 供客户端用户登录时，根据手机号码获取短信验证码
	 *
	 * @param getVerifyCodeRequset
	 * @return
	 */
	@POST
	@Path ("/getVerifyCode")
	@Produces (MediaType.APPLICATION_JSON)
	Result getVerifyCode (GetVerifyCodeRequset getVerifyCodeRequset);

	/**
	 * 用户登录
	 * 供客户端用户根据手机号码登录
	 *
	 * @param loginRequest
	 * @return
	 */
	@POST
	@Path ("/login")
	@Produces (MediaType.APPLICATION_JSON)
	Result<Token> login (LoginRequest loginRequest);

	/**
	 * 查询用户下载历史记录(分区表)
	 * 供客户端用户根据手机号码登录
	 *
	 * @return
	 */
	@POST
	@Path ("/downloadRecord")
	@Produces (MediaType.APPLICATION_JSON)
	Result<List<AppDto>> downloadRecord (DownloadRecordRequest downloadRecordRequest);

	/**
	 * 猜你喜欢的游戏应用推荐
	 * 游戏详情页，下载管理页中的猜你喜欢游戏应用推荐接口
	 *
	 * @param getRecommandAppRequest
	 * @return
	 */
	@POST
	@Path ("/appRecommand")
	@Produces (MediaType.APPLICATION_JSON)
	Result<List<AppDto>> appRecommand (GetRecommandAppRequest getRecommandAppRequest);

	/**
	 * 根据用户账号获取应用下载地址接口
	 *
	 * @param getAppDownload
	 * @return
	 */
	@POST
	@Path ("/getAppDownload")
	@Produces (MediaType.APPLICATION_JSON)
	Result<String> getAppDownload (GetAppDownloadRequest getAppDownload);

	/**
	 * 获取用户Token
	 *
	 * @param getAccessTokenRequest
	 * @return
	 */
	@POST
	@Path ("/getAccessToken")
	@Produces (MediaType.APPLICATION_JSON)
	Result<Token> getAccessToken (GetAccessTokenRequest getAccessTokenRequest);

	/**
	 * 查询用户生效的订购套餐
	 *
	 * @param queryUserOrderRequest
	 * @return
	 */
	Result<Order> queryUserOrder (QueryUserOrderRequest queryUserOrderRequest);
}
