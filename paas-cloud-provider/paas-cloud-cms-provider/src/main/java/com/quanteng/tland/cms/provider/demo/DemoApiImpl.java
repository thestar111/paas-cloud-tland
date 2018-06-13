/**
 * 文 件 名:  DemoApiImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/8 0008
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.cms.provider.demo;

import com.quanteng.tland.cms.api.demo.DemoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/5/8 0008
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class DemoApiImpl implements DemoApi
{

	@Autowired
	private HttpServletRequest request;

	/**
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	@Override
	public String sayHello (@PathVariable ("name") String userName) throws Exception
	{
		return "";
	}
}
