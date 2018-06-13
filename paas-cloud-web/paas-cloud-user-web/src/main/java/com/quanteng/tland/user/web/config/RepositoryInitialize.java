/**
 * 文 件 名:  RepositoryInitialize
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/12 0012
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.user.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.quanteng.tland.common.exception.UserException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/12 0012
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
@EnableConfigurationProperties (DataSource.class)
@AutoConfigureAfter (DataSource.class)
public class RepositoryInitialize
{
	private static final Logger LOGGER = LoggerFactory.getLogger (RepositoryInitialize.class);

	/**
	 * 实体类包路径
	 */
	private static final String MODEL_PACKAGE_PATH = "com.quanteng.tland.user.database.entity";

	/**
	 * mybatis配置文件路径
	 */
	private static final String MYBATIS_PATH = "classpath:/mybatis-config.xml";

	/**
	 * mybatis映射文件路径
	 */
	private static final String MAPPER_PATH = "classpath:/mapper/*.xml";

	@Autowired
	private DruidDataSource druidDataSource;

	@Bean (name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory ()
	{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean ();
		sqlSessionFactoryBean.setDataSource (druidDataSource);

		/*扫描DOMAIN包，可以使用别名*/
		sqlSessionFactoryBean.setTypeAliasesPackage (MODEL_PACKAGE_PATH);

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver ();

		try
		{
			/*扫描mybatis配置文件*/
			sqlSessionFactoryBean.setConfigLocation (resolver.getResource (MYBATIS_PATH));
			sqlSessionFactoryBean.setMapperLocations (resolver.getResources (MAPPER_PATH));
			return sqlSessionFactoryBean.getObject ();
		}
		catch (Exception e)
		{
			LOGGER.error ("init database error.", e);
			throw new UserException ("99999999", "init database failed.");
		}
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate (SqlSessionFactory sqlSessionFactory)
	{
		return new SqlSessionTemplate (sqlSessionFactory);
	}
}
