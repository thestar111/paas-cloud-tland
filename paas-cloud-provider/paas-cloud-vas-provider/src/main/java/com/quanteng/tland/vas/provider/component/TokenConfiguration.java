/**
 * 文 件 名:  TokenConfiguration
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/16 0016
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.vas.provider.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/16 0016
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
@Component
@ConfigurationProperties (prefix = "security.token")
public class TokenConfiguration
{

	/**
	 * {@link com.quanteng.tland.api.gateway.configuration} token过期时间（分钟）
	 */
	private Integer expirationTime;

	/**
	 * {@link com.quanteng.tland.api.gateway.configuration} token发行人
	 */
	private String issuer;

	/**
	 * {@link com.quanteng.tland.api.gateway.configuration} token签名私有key
	 */
	private String signingKey;

	/**
	 * {@link com.quanteng.tland.api.gateway.configuration} 刷新过期时间（分钟）
	 */
	private Integer refreshExpTime;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("TokenConfiguration{");
		sb.append ("expirationTime=").append (expirationTime);
		sb.append (", issuer='").append (issuer).append ('\'');
		sb.append (", signingKey='").append (signingKey).append ('\'');
		sb.append (", refreshExpTime=").append (refreshExpTime);
		sb.append ('}');
		return sb.toString ();
	}
}
