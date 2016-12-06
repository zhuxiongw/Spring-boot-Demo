package org.spring.redis.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DataSourcePool {
	@Value("${spring.datasource.driverClassName}")
	private String driver;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.maxActive}")
	private int maxActive;
	@Value("${spring.datasource.initSize}")
	private int initSize;
	@Value("${spring.datasource.maxWait}")
	private long maxWait;
	@Bean(name="dataSource",destroyMethod="close",initMethod = "init")
	public DataSource initDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setMaxWait(maxWait);
		dataSource.setInitialSize(initSize);
		dataSource.setMaxActive(maxActive);
		return dataSource;
	}

}
