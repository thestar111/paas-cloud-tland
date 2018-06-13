/**
 * 文 件 名:  AppBootstrap
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/12 0012
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng;

import com.quanteng.tland.charging.database.entity.Order;
import com.quanteng.tland.charging.database.mapper.OrderMapper;
import com.quanteng.tland.charging.web.boot.ChargingServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/12 0012
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest (classes = ChargingServiceApplication.class)
public class AppBootstrap
{

	@Autowired
	private OrderMapper orderMapper;

	@Test
	public void turn () throws Exception
	{
		Order order = new Order ();
		order.setSubEndTime ("20180412125959");
	}
}
