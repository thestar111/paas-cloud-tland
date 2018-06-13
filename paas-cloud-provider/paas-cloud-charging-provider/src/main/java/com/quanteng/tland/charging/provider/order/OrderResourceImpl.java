/**
 * 文 件 名:  OrderResourceImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/26 0026
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.charging.provider.order;

import com.quanteng.tland.charging.api.order.OrderResource;
import com.quanteng.tland.charging.pojo.order.domain.OrderVo;
import com.quanteng.tland.charging.pojo.order.request.CreateOrderRequest;
import com.quanteng.tland.charging.pojo.order.request.ModifyOrderRequest;
import com.quanteng.tland.charging.pojo.order.request.ModifyOrderStatusRequest;
import com.quanteng.tland.charging.pojo.order.request.QueryOrderConditionRequest;
import com.quanteng.tland.charging.pojo.order.response.QueryOrderConditionResponse;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.RestController;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/5/26 0026
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class OrderResourceImpl implements OrderResource
{
	/**
	 * 创建订单信息
	 *
	 * @param createOrderRequest
	 * @return
	 */
	@Override
	public Result<String> createOrder (CreateOrderRequest createOrderRequest)
	{
		return null;
	}

	/**
	 * 修改订单信息
	 *
	 * @param modifyOrderRequest
	 * @return
	 */
	@Override
	public Result<String> modifyOrder (ModifyOrderRequest modifyOrderRequest)
	{
		return null;
	}

	/**
	 * 修改订单状态信息
	 *
	 * @param modifyOrderStatusRequest
	 * @return
	 */
	@Override
	public Result<String> modifyOrderStatus (ModifyOrderStatusRequest modifyOrderStatusRequest)
	{
		return null;
	}

	/**
	 * 查询当前生效订单信息
	 *
	 * @param account
	 * @return
	 */
	@Override
	public Result<OrderVo> queryEffectiveOrder (String account)
	{
		return null;
	}

	/**
	 * 查询订单信息
	 *
	 * @param queryOrderConditionRequest
	 * @return
	 */
	@Override
	public Result<QueryOrderConditionResponse> queryOrders (QueryOrderConditionRequest queryOrderConditionRequest)
	{
		return null;
	}
}
