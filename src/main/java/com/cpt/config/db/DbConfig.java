package com.cpt.config.db;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages="com.cpt.*.mapper.**")
public class DbConfig {

    /**
     *Load the properties
     */
	@Value("${jdbc.driverClassName}")
	private String driverClass;
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	@Value("${druid.pool.initialSize}")
	private Integer initialSize;
	@Value("${druid.pool.minIdle}")
	private int minIdle;
	@Value("${druid.pool.maxActive}")
	private int maxActive;
	@Value("${druid.pool.maxWait}")
	private long maxWaitMillis;
	@Value("${druid.pool.timeBetweenEvictionRunsMillis}")
	private long timeBetweenEvictionRunsMillis;
	@Value("${druid.pool.minEvictableIdleTimeMillis}")
	private long minEvictableIdleTimeMillis;
	@Value("${druid.pool.validationQuery}")
	private String validationQuery;
	@Value("${druid.pool.testWhileIdle}")
	private boolean testWhileIdle;
	@Value("${druid.pool.testOnBorrow}")
	private boolean testOnBorrow;
	@Value("${druid.pool.testOnReturn}")
	private boolean testOnReturn;
	@Value("${druid.pool.poolPreparedStatements}")
	private boolean poolPreparedStatements;
	@Value("${druid.pool.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;
    
    @Bean
	public DataSource dataSource(){
		DruidDataSource druidDs = new DruidDataSource();
		druidDs.setDriverClassName(driverClass);
		druidDs.setUrl(jdbcUrl);
		druidDs.setUsername(username);
		druidDs.setPassword(password);
		druidDs.setInitialSize(initialSize);
		druidDs.setMinIdle(minIdle);
		druidDs.setMaxActive(maxActive);
		druidDs.setMaxWait(maxWaitMillis);
		druidDs.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		druidDs.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		druidDs.setValidationQuery(validationQuery);
		druidDs.setTestWhileIdle(testWhileIdle);
		druidDs.setTestOnBorrow(testOnBorrow);
		druidDs.setTestOnReturn(testOnReturn);
		druidDs.setPoolPreparedStatements(poolPreparedStatements);
		druidDs.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		return druidDs;
	}
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        //Resource resource = new ClassPathResource();
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/cpt/*/mapper/**.xml"));
        
        //增加分页插件
	    PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.put("dialect", "mysql");
        properties.put("reasonable", true);
        pageHelper.setProperties(properties);
        sessionFactory.setPlugins(new Interceptor[]{pageHelper});
        
        return sessionFactory.getObject();
    }
 
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
	    return new DataSourceTransactionManager(dataSource);
	}
	
}
