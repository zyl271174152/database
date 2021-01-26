package com.zyl.database.datasourceconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * 自定义restTemplate
 */
@Configuration
public class RestTemplateConfig {

    private RestTemplate restTemplate;

    /**
     * '@LoadBalanced'注解表示使用Ribbon实现客户端负载均衡
     *
     * @return RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        if (restTemplate == null) {
            SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
            factory.setReadTimeout(10000);
            //ms
            factory.setConnectTimeout(5000);
            //ms
            restTemplate = new RestTemplate(factory);
            restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        }
        return restTemplate;
    }


}
