package net.masamic.app.web.sample1.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("Classpath:application.properties")
public class DataSourceConfig {

	@Bean(destroyMethod="close")
	public DataSource dataSource(
			@Value("${spring.datasource.driverClassName}") String driverClassName,
			@Value("${spring.datasource.url}") String url,
			@Value("${spring.datasource.username}") String userName,
			@Value("${spring.datasource.password}") String password,
			@Value("${spring.datasource.cp.maxTotal}") int maxTotal,
			@Value("${spring.datasource.cp.maxIdle}") int maxIdle,
			@Value("${spring.datasource.cp.minIdle}") int minIdle,
			@Value("${spring.datasource.cp.maxWaitMillis}") long maxWaitMillis) {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		dataSource.setMaxTotal(maxTotal);
		dataSource.setMaxIdle(maxIdle);
		dataSource.setMinIdle(minIdle);
		dataSource.setMaxWaitMillis(maxWaitMillis);
		
		return dataSource;
	}
}
