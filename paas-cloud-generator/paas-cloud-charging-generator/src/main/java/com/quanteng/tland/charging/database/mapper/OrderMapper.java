/**
 * 文 件 名:  OrderMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/4 0004
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.charging.database.mapper;

import com.quanteng.tland.charging.database.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <套餐订购MAPPER>
 *
 * @author zping
 * @version 2018/5/4 0004
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface OrderMapper
{
	/**
	 * 添加订购记录
	 *
	 * @param order
	 */
	int createOrder (Order order);

	/**
	 * 修改用户订购关系
	 *
	 * @param order
	 * @return
	 */
	int modifyOrder (Order order);

	/**
	 * 修改订单状态
	 *
	 * @param status
	 * @param orderId
	 * @return
	 */
	int modifyOrderStatus (@Param ("status") String status, @Param ("orderId") String orderId);

	/**
	 * 查询用户当前生效订购记录
	 *
	 * @param accountId
	 * @return
	 */
	Order queryEffectiveOrder (String accountId);

	/**
	 * 查询用户订购记录
	 *
	 * @param map
	 * @return
	 */
	List<Order> queryOrderByCondition (Map<String, String> map);

	/**
	 * 查询用户订购记录总数
	 *
	 * @param map
	 * @return
	 */
	Integer queryOrderCountByCondition (Map<String, String> map);
}
