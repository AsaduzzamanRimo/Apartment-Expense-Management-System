package com.epam.apartmentbooking.config;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import org.apache.commons.dbcp2.BasicDataSource;
import org.dbunit.ext.oracle.OracleDataTypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan({"com.epam.apartmentbooking.domain","com.epam.apartmentbooking.dao"})
@PropertySources(value = {@PropertySource("classpath:db.properties")})
@Import(EmailConfig.class)
public class TestConfig {

    @Autowired
    private Environment environment;

    private static final int INITIAL_POOL_SIZE = 20;
    private static final int MAX_POOL_SIZE = 200;

    @Bean
    public DataSource testDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.testUsername"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.testPassword"));
        dataSource.setInitialSize(INITIAL_POOL_SIZE);
        dataSource.setMaxTotal(MAX_POOL_SIZE);
        return dataSource;
    }

    @Autowired
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource testDataSource){
        return new JdbcTemplate(testDataSource);
    }

    @Bean
    public DatabaseConfigBean dbUnitDatabaseConfig() {
        DatabaseConfigBean dbConfig = new DatabaseConfigBean();
        dbConfig.setDatatypeFactory(new OracleDataTypeFactory());
        return dbConfig;
    }

    @Bean
    @Autowired
    public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection(DataSource testDataSource) {
        DatabaseDataSourceConnectionFactoryBean dbConnFactoryBean = new DatabaseDataSourceConnectionFactoryBean();
        dbConnFactoryBean.setDatabaseConfig(dbUnitDatabaseConfig());
        dbConnFactoryBean.setDataSource(testDataSource);
        dbConnFactoryBean.setSchema(environment.getRequiredProperty("jdbc.testSchema"));
        return dbConnFactoryBean;
    }

}
