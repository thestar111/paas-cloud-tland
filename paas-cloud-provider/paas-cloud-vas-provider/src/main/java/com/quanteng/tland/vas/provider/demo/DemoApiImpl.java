/**
 * 文 件 名:  DemoApiImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/8 0008
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.provider.demo;

import com.quanteng.tland.common.annotation.Api;
import com.quanteng.tland.vas.api.demo.DemoApi;
import com.quanteng.tland.vas.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/8 0008
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Api
public class DemoApiImpl implements DemoApi
{

	@Autowired
	private UserService userService;

	@Override
	public String sayHello (HttpServletRequest request, String userName) throws Exception
	{
		return "";
	}

	@Override
	public String sayHello2 (HttpServletRequest request, String userName) throws Exception
	{
		return "{resultMessage : " + userName + "}";
	}
}
