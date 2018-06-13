/**
 * 文 件 名:  SettingService
 * 版    权:  Quanten Teams. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhengbinggui
 * 修改时间:  2018/5/18
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.service.setting;

import com.quanteng.tland.cms.api.setting.SettingsResource;
import com.quanteng.tland.configuration.GlobalFeignConfiguration;
import com.quanteng.tland.vas.service.catalogrelation.CatalogRelationFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <定义配置Api服务降级>
 *
 * @author zhengbinggui
 * @version 2018/5/18
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@FeignClient (value = "tland-cms-service", fallbackFactory = SettingFallbackFactory.class, configuration = GlobalFeignConfiguration.class)
public interface SettingService extends SettingsResource
{
}
