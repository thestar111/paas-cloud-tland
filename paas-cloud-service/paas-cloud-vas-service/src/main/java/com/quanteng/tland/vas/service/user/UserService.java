/**
 * 文 件 名:  UserService
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/9 0009
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.service.user;

import com.quanteng.tland.configuration.GlobalFeignConfiguration;
import com.quanteng.tland.user.api.user.UserResourceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <User FeignClient>
 * value: 制定Eureka中的服务ID
 * fallbackFactory: 服务降级调用本地工厂方法
 *
 * @author zping
 * @version 2018/4/9 0009
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@FeignClient (value = "tland-user-service", fallbackFactory = UserFallbackFactory.class, configuration = GlobalFeignConfiguration.class)
public interface UserService extends UserResourceApi
{
}
