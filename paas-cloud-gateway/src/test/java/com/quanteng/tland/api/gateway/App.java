/**
 * 文 件 名:  App
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/6/1 0001
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.api.gateway;

import com.quanten.core.utils.Coder;
import com.quanteng.tland.api.gateway.boot.TlandApiGatewayApplication;
import com.quanteng.tland.api.gateway.configuration.AppKeyConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/6/1 0001
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RunWith (SpringRunner.class)
@SpringBootTest (classes = TlandApiGatewayApplication.class)
public class App
{

	/**
	 * App Key 密钥
	 */
	@Autowired
	private AppKeyConfiguration appKeyConfiguration;

	/**
	 * 系统初始化
	 */
	@Test
	public void contextLoad () throws Exception
	{
		long timestamp = System.currentTimeMillis ();
		System.out.println (timestamp);
		System.out.println (Coder.encryptBASE64 (Coder.encryptMD5 (
				(appKeyConfiguration.getKeys ().get ("secretId") + timestamp + appKeyConfiguration.getKeys ()
						.get ("secretId")).getBytes ())));
	}
}
