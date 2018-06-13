/**
 * 文 件 名:  ChargingFallbackFactory
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/10 0010
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.service.charging;

import com.quanteng.tland.vas.service.order.OrderService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/10 0010
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class ChargingFallbackFactory implements FallbackFactory<OrderService>
{
	@Override
	public OrderService create (Throwable throwable)
	{
		return null;
	}
}
