/**
 * 文 件 名:  DemoApi
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/8 0008
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.api.demo;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/8 0008
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Path ("/demo")
public interface DemoApi
{
	@POST
	@Path ("/say")
	@Produces (MediaType.TEXT_PLAIN)
	String sayHello (@Context HttpServletRequest request, @QueryParam ("name") String userName) throws Exception;

	@POST
	@Path ("/say2")
	@Produces (MediaType.APPLICATION_JSON)
	String sayHello2 (@Context HttpServletRequest request, @QueryParam ("name") String userName) throws Exception;
}
