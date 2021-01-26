package com.zyl.database.datasourceconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class DataSourceCustomzeConfig {

    @Bean("mysql")
    @ConfigurationProperties("spring.datasource")
    public DataSource DataSourceMysql() {
        DruidDataSource build = DruidDataSourceBuilder.create().build();
//        build.setKeepAlive();
//        build.setInitialSize();
        return build;
    }

//    @Bean("oracle")
//    @ConfigurationProperties("spring.datasource.test")
//    public DataSource DataSourceOracle() {
//        DruidDataSource build = DruidDataSourceBuilder.create().build();
//        return build;
//    }

//    //配置Druid的监控
//    //1、配置一个管理后台的Servlet
//    @Bean
//    public ServletRegistrationBean statViewServlet(){
//        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        Map<String,String> initParams = new HashMap<>();
//
//        initParams.put("loginUsername","admin");
//        initParams.put("loginPassword","123456");
//        initParams.put("allow","");//默认就是允许所有访问
//        initParams.put("deny","192.168.15.21"); //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
//        initParams.put("resetEnable","false");  //是否能够重置数据.
//
//        bean.setInitParameters(initParams);
//        return bean;
//    }


//    //2、配置一个web监控的filter
//    @Bean
//    public FilterRegistrationBean webStatFilter(){
//        FilterRegistrationBean bean = new FilterRegistrationBean();
//        bean.setFilter(new WebStatFilter());
//
//        Map<String,String> initParams = new HashMap<>();
//        initParams.put("exclusions","*.js,*.css,/druid/*");
//
//        bean.setInitParameters(initParams);
//
//        bean.setUrlPatterns(Arrays.asList("/*"));
//
//        return  bean;
//    }


    /**
     * 注入数据源
     *
     * @return
     */
    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("mysql", DataSourceMysql());
//        targetDataSources.put("oracle", DataSourceOracle());
        return new DynamicDataSource(DataSourceMysql(), targetDataSources);
    }

}