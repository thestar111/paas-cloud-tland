/**
 * 文 件 名:  ChargingService
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/10 0010
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.service.charging;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * <计费中心服务降级本地方法>
 * 		value ： 服务名称
 * 		fallbackFactory ： 服务降级本地方法
 *
 * @author zping
 * @version 2018/4/10 0010
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@FeignClient (value = "tland-charging-service", fallbackFactory = ChargingFallbackFactory.class)
public interface ChargingService
{
}
