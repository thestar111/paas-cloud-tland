/**
 * 文 件 名:  AppKeyConfiguration
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/6/1 0001
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.api.gateway.configuration;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/6/1 0001
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
@Component
@ConfigurationProperties (prefix = "security")
public class AppKeyConfiguration
{

	/**
	 * AppKey 存储集合
	 */
	private Map<String, String> keys = Maps.newHashMap ();

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AppKeyConfiguration{");
		sb.append ("keys=").append (keys);
		sb.append ('}');
		return sb.toString ();
	}
}
