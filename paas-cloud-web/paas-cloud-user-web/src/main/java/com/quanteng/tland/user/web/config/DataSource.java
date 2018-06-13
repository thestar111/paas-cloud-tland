/**
 * 文 件 名:  MyDataSou
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.quanteng.tland.user.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * <自定义数据源>
 *
 * @author zping
 * @version 2018/4/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties (prefix = "spring.datasource")
public class DataSource
{
	private String username;

	private String password;

	private String url;

	private String driverClassName;

	private String filters;

	private String connectionProperties;

	private String validationQuery;

	private Boolean testWhileIdle;

	private Boolean testOnBorrow;

	private Boolean testOnReturn;

	private Boolean poolPreparedStatements;

	private Integer maxWait;

	private Integer maxActive;

	private Integer minIdle;

	private Integer initialSize;

	private Integer timeBetweenEvictionRunsMillis;

	private Integer minEvictableIdleTimeMillis;

	private Integer maxPoolPreparedStatementPerConnectionSize;

	@Bean ("druidDataSource")
	public DruidDataSource druidDataSource ()
	{
		DruidDataSource druidDataSource = new DruidDataSource ();
		druidDataSource.setUsername (this.getUsername ());
		druidDataSource.setPassword (this.getPassword ());
		druidDataSource.setUrl (this.getUrl ());

		if (this.getInitialSize ().intValue () > 0)
		{
			druidDataSource.setInitialSize (this.getInitialSize ().intValue ());
		}

		if (this.getMinIdle ().intValue () > 0)
		{
			druidDataSource.setMinIdle (this.getMinIdle ().intValue ());
		}

		if (this.getMaxActive ().intValue () > 0)
		{
			druidDataSource.setMaxActive (this.getMaxActive ().intValue ());
		}

		if (this.getTestOnBorrow () != null)
		{
			druidDataSource.setTestOnBorrow (this.getTestOnBorrow ().booleanValue ());
		}

		if (this.getMaxWait ().intValue () > 0)
		{
			druidDataSource.setMaxWait (this.getMaxWait ().intValue ());
		}

		if (this.getTimeBetweenEvictionRunsMillis ().intValue () > 0)
		{
			druidDataSource.setTimeBetweenEvictionRunsMillis (this.getTimeBetweenEvictionRunsMillis ().intValue ());
		}

		if (this.getMinEvictableIdleTimeMillis ().intValue () > 0)
		{
			druidDataSource.setMinEvictableIdleTimeMillis (this.getMinEvictableIdleTimeMillis ().intValue ());
		}

		if (this.getValidationQuery () != null)
		{
			druidDataSource.setValidationQuery (this.getValidationQuery ());
		}

		if (this.getTestWhileIdle () != null)
		{
			druidDataSource.setTestWhileIdle (this.getTestWhileIdle ().booleanValue ());
		}

		if (this.getTestOnReturn () != null)
		{
			druidDataSource.setTestOnReturn (this.getTestOnReturn ().booleanValue ());
		}

		if (this.getPoolPreparedStatements () != null)
		{
			druidDataSource.setPoolPreparedStatements (this.getPoolPreparedStatements ().booleanValue ());
		}

		if (this.getMaxPoolPreparedStatementPerConnectionSize ().intValue () > 0)
		{
			druidDataSource.setMaxPoolPreparedStatementPerConnectionSize (
					this.getMaxPoolPreparedStatementPerConnectionSize ().intValue ());
		}

		if (this.getFilters () != null)
		{
			try
			{
				druidDataSource.setFilters (this.getFilters ());
			}
			catch (SQLException e)
			{
				e.printStackTrace ();
			}
		}

		if (this.getConnectionProperties () != null)
		{
			druidDataSource.setConnectionProperties (this.getConnectionProperties ());
		}

		try
		{
			druidDataSource.init ();
		}
		catch (SQLException e)
		{
			throw new RuntimeException (e);
		}
		return druidDataSource;
	}

	public String getUsername ()
	{
		return username;
	}

	public void setUsername (String username)
	{
		this.username = username;
	}

	public String getPassword ()
	{
		return password;
	}

	public void setPassword (String password)
	{
		this.password = password;
	}

	public String getUrl ()
	{
		return url;
	}

	public void setUrl (String url)
	{
		this.url = url;
	}

	public String getDriverClassName ()
	{
		return driverClassName;
	}

	public void setDriverClassName (String driverClassName)
	{
		this.driverClassName = driverClassName;
	}

	public String getFilters ()
	{
		return filters;
	}

	public void setFilters (String filters)
	{
		this.filters = filters;
	}

	public String getConnectionProperties ()
	{
		return connectionProperties;
	}

	public void setConnectionProperties (String connectionProperties)
	{
		this.connectionProperties = connectionProperties;
	}

	public String getValidationQuery ()
	{
		return validationQuery;
	}

	public void setValidationQuery (String validationQuery)
	{
		this.validationQuery = validationQuery;
	}

	public Boolean getTestWhileIdle ()
	{
		return testWhileIdle;
	}

	public void setTestWhileIdle (Boolean testWhileIdle)
	{
		this.testWhileIdle = testWhileIdle;
	}

	public Boolean getTestOnBorrow ()
	{
		return testOnBorrow;
	}

	public void setTestOnBorrow (Boolean testOnBorrow)
	{
		this.testOnBorrow = testOnBorrow;
	}

	public Boolean getTestOnReturn ()
	{
		return testOnReturn;
	}

	public void setTestOnReturn (Boolean testOnReturn)
	{
		this.testOnReturn = testOnReturn;
	}

	public Boolean getPoolPreparedStatements ()
	{
		return poolPreparedStatements;
	}

	public void setPoolPreparedStatements (Boolean poolPreparedStatements)
	{
		this.poolPreparedStatements = poolPreparedStatements;
	}

	public Integer getMaxWait ()
	{
		return maxWait;
	}

	public void setMaxWait (Integer maxWait)
	{
		this.maxWait = maxWait;
	}

	public Integer getMaxActive ()
	{
		return maxActive;
	}

	public void setMaxActive (Integer maxActive)
	{
		this.maxActive = maxActive;
	}

	public Integer getMinIdle ()
	{
		return minIdle;
	}

	public void setMinIdle (Integer minIdle)
	{
		this.minIdle = minIdle;
	}

	public Integer getInitialSize ()
	{
		return initialSize;
	}

	public void setInitialSize (Integer initialSize)
	{
		this.initialSize = initialSize;
	}

	public Integer getTimeBetweenEvictionRunsMillis ()
	{
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis (Integer timeBetweenEvictionRunsMillis)
	{
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public Integer getMinEvictableIdleTimeMillis ()
	{
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis (Integer minEvictableIdleTimeMillis)
	{
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public Integer getMaxPoolPreparedStatementPerConnectionSize ()
	{
		return maxPoolPreparedStatementPerConnectionSize;
	}

	public void setMaxPoolPreparedStatementPerConnectionSize (Integer maxPoolPreparedStatementPerConnectionSize)
	{
		this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
	}

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("DataSource{");
		sb.append ("username='").append (username).append ('\'');
		sb.append (", password='").append (password).append ('\'');
		sb.append (", url='").append (url).append ('\'');
		sb.append (", driverClassName='").append (driverClassName).append ('\'');
		sb.append (", filters='").append (filters).append ('\'');
		sb.append (", connectionProperties='").append (connectionProperties).append ('\'');
		sb.append (", validationQuery='").append (validationQuery).append ('\'');
		sb.append (", testWhileIdle=").append (testWhileIdle);
		sb.append (", testOnBorrow=").append (testOnBorrow);
		sb.append (", testOnReturn=").append (testOnReturn);
		sb.append (", poolPreparedStatements=").append (poolPreparedStatements);
		sb.append (", maxWait=").append (maxWait);
		sb.append (", maxActive=").append (maxActive);
		sb.append (", minIdle=").append (minIdle);
		sb.append (", initialSize=").append (initialSize);
		sb.append (", timeBetweenEvictionRunsMillis=").append (timeBetweenEvictionRunsMillis);
		sb.append (", minEvictableIdleTimeMillis=").append (minEvictableIdleTimeMillis);
		sb.append (", maxPoolPreparedStatementPerConnectionSize=").append (maxPoolPreparedStatementPerConnectionSize);
		sb.append ('}');
		return sb.toString ();
	}
}
