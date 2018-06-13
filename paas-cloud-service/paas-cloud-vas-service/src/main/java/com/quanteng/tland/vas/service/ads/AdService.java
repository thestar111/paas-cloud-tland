/**
 * 文 件 名:  AdService
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/25 0025
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.service.ads;

import com.quanteng.tland.cms.api.ad.AdResource;
import com.quanteng.tland.configuration.GlobalFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <广告服务降级>
 *
 * @author zping
 * @version 2018/4/25 0025
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@FeignClient (value = "tland-cms-service", fallbackFactory = AdsFallbackFactory.class, configuration = GlobalFeignConfiguration.class)
public interface AdService extends AdResource
{
}
