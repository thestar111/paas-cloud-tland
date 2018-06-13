/**
 * 文 件 名:  BundleServcie
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  LJun
 * 修改时间:  2018/5/15
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.service.bundle;

import com.quanteng.tland.cms.api.bundle.BundleResource;
import com.quanteng.tland.configuration.GlobalFeignConfiguration;
import com.quanteng.tland.vas.service.bundle.BundleFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <套餐服务降级>
 *
 * @author LJun
 * @version 2018/5/15queryBundlesByCondition
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@FeignClient (value = "tland-cms-service", fallbackFactory = BundleFallbackFactory.class, configuration = GlobalFeignConfiguration.class)
public interface BundleServcie extends BundleResource
{

}
