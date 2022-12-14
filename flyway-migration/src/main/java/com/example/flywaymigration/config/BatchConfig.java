package com.example.flywaymigration.config;

import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig  {

    @ConfigurationProperties("spring.datasource")
    @Bean
    @Primary
    protected DataSource batchDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    protected PlatformTransactionManager batchTransactionManager() {
        return new ResourcelessTransactionManager();
    }

}