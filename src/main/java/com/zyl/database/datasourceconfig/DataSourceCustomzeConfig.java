package com.zyl.database.datasourceconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuyanli
 * @date 2020/9/14 16:22
 * @description
 */
@Configuration
public class DataSourceCustomzeConfig {

    @Bean("mysql")
    @ConfigurationProperties("spring.datasource")
    public DataSource DataSourceMysql() {
        DruidDataSource build = DruidDataSourceBuilder.create().build();
//        build.setKeepAlive();
//        build.setInitialSize();
        return build;
    }

    @Bean("oracle")
    @ConfigurationProperties("spring.datasource.test")
    public DataSource DataSourceOracle() {
        DruidDataSource build = DruidDataSourceBuilder.create().build();
        return build;
    }


    /**
     * 注入数据源
     *
     * @return
     */
    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>()
;
        targetDataSources.put("mysql", DataSourceMysql());
                targetDataSources.put("oracle", DataSourceOracle());
                return new DynamicDataSource(DataSourceOracle(), targetDataSources);
                }

                }