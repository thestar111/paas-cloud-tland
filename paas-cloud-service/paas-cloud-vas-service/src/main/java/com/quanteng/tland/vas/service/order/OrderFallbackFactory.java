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
package com.quanteng.tland.vas.service.order;

import com.quanteng.tland.charging.pojo.order.domain.OrderVo;
import com.quanteng.tland.charging.pojo.order.request.CreateOrderRequest;
import com.quanteng.tland.charging.pojo.order.request.ModifyOrderRequest;
import com.quanteng.tland.charging.pojo.order.request.ModifyOrderStatusRequest;
import com.quanteng.tland.charging.pojo.order.request.QueryOrderConditionRequest;
import com.quanteng.tland.charging.pojo.order.response.QueryOrderConditionResponse;
import com.quanteng.tland.common.domain.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class OrderFallbackFactory implements FallbackFactory<OrderService>
{

	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (OrderFallbackFactory.class);

	@Override
	public OrderService create (Throwable throwable)
	{
		LOGGER.error (String.format ("Charging Service Not Available : %s", throwable));
		return new OrderService ()
		{
			@Override
			public Result<String> createOrder (CreateOrderRequest createOrderRequest)
			{
				return new Result<> ().failure ("Charging Service Not Avaliable");
			}

			@Override
			public Result<String> modifyOrder (ModifyOrderRequest modifyOrderRequest)
			{
				return new Result<> ().failure ("Charging Service Not Avaliable");
			}

			@Override
			public Result<String> modifyOrderStatus (ModifyOrderStatusRequest modifyOrderStatusRequest)
			{
				return new Result<> ().failure ("Charging Service Not Avaliable");
			}

			@Override
			public Result<OrderVo> queryEffectiveOrder (String account)
			{
				return new Result<> ().failure ("Charging Service Not Avaliable");
			}

			@Override
			public Result<QueryOrderConditionResponse> queryOrders (
					QueryOrderConditionRequest queryOrderConditionRequest)
			{
				return new Result<> ().failure ("Charging Service Not Avaliable");
			}
		};
	}
}
