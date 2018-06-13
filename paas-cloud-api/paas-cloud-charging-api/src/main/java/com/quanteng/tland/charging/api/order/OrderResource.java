/**
 * 文 件 名:  OrderResource
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/3 0003
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.charging.api.order;

import com.quanteng.tland.charging.pojo.order.domain.OrderVo;
import com.quanteng.tland.charging.pojo.order.request.CreateOrderRequest;
import com.quanteng.tland.charging.pojo.order.request.ModifyOrderRequest;
import com.quanteng.tland.charging.pojo.order.request.ModifyOrderStatusRequest;
import com.quanteng.tland.charging.pojo.order.request.QueryOrderConditionRequest;
import com.quanteng.tland.charging.pojo.order.response.QueryOrderConditionResponse;
import com.quanteng.tland.common.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <套餐订购资源接口管理>
 *
 * @author zping
 * @version 2018/5/3 0003
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping ("/charging/order")
public interface OrderResource
{
	/**
	 * 创建订单信息
	 *
	 * @return
	 */
	@RequestMapping (value = "/add", method = RequestMethod.POST)
	Result<String> createOrder (@RequestBody CreateOrderRequest createOrderRequest);

	/**
	 * 修改订单信息
	 *
	 * @return
	 */
	@RequestMapping (value = "/modify", method = RequestMethod.PUT)
	Result<String> modifyOrder (@RequestBody ModifyOrderRequest modifyOrderRequest);

	/**
	 * 修改订单状态信息
	 *
	 * @return
	 */
	@RequestMapping (value = "/changeStatus", method = RequestMethod.PUT)
	Result<String> modifyOrderStatus (@RequestBody ModifyOrderStatusRequest modifyOrderStatusRequest);

	/**
	 * 查询当前生效订单信息
	 *
	 * @return
	 */
	@RequestMapping (value = "/effective/{account}", method = RequestMethod.GET)
	Result<OrderVo> queryEffectiveOrder (@PathVariable ("account") String account);

	/**
	 * 查询订单信息
	 *
	 * @return
	 */
	@RequestMapping (value = "/list", method = RequestMethod.POST)
	Result<QueryOrderConditionResponse> queryOrders (
			@RequestBody QueryOrderConditionRequest queryOrderConditionRequest);
}
