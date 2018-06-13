/**
 * 文 件 名:  MapperScanConfig
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/12 0012
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.charging.web.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/12 0012
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
public class MapperScanConfig
{
	/**
	 * Mapper 扫描路径
	 */
	private static final String MAPPER_PACK = "com.quanteng.tland.charging.database.mapper";

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer ()
	{
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer ();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName ("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage (MAPPER_PACK);
		return mapperScannerConfigurer;
	}
}
