package com.pofo.appmgmt.configure;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

@Configuration
@MapperScan(value = "com.pofo.appmgmt", sqlSessionFactoryRef = "sqlSessionFactory")
@EnableTransactionManagement
public class MybatisConfiguration {

	@Primary
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext applicationContext) throws Exception {
		
		// mybatis config
		org.apache.ibatis.session.Configuration mybatisConfiguration = new org.apache.ibatis.session.Configuration();
		mybatisConfiguration.setMapUnderscoreToCamelCase(true);
		mybatisConfiguration.setJdbcTypeForNull(JdbcType.NULL);
		mybatisConfiguration.setDefaultFetchSize(100);
		mybatisConfiguration.setDefaultStatementTimeout(55);
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage("com.pofo.appmgmt");
		sqlSessionFactoryBean.setConfiguration(mybatisConfiguration);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/**/*Mapper.xml"));
		return sqlSessionFactoryBean.getObject();
	}
	
	@Primary
	@Bean(name = "sqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
