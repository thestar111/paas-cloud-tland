/**
 * 文 件 名:  CatalogService
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:   LJun
 * 修改时间:  2018/5/17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.service.catalog;

import com.quanteng.tland.cms.api.catalog.CatalogResource;
import com.quanteng.tland.configuration.GlobalFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <栏目服务降级>
 *
 * @author LJun
 * @version 2018/5/17
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@FeignClient (value = "tland-cms-service", fallbackFactory = CatalogFallbackFactory.class, configuration = GlobalFeignConfiguration.class)
public interface CatalogService extends CatalogResource
{
}
