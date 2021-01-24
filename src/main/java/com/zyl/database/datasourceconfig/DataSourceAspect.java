package com.zyl.database.datasourceconfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author zhuyanli
 * @date 2020/9/15 13:50
 * @description 拦截注解改变数据源
 */
@Aspect
@Order(-1)
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(com.zyl.database.datasourceconfig.DataSource)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object ChangeDataSource(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource dataSource = method.getAnnotation(DataSource.class);
        if (dataSource != null) {
            DynamicDataSource.setDataSourceType(dataSource.value());
        }
        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            DynamicDataSource.clearDataSourceType();
        }
    }
}
