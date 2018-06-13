/**
 * 文 件 名:  OrderService
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/26 0026
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.service.order;

import com.quanteng.tland.charging.api.order.OrderResource;
import com.quanteng.tland.configuration.GlobalFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/5/26 0026
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@FeignClient (name = "tland-charging-service", fallbackFactory = OrderFallbackFactory.class, configuration = GlobalFeignConfiguration.class)
public interface OrderService extends OrderResource
{
}
