package com.zyl.database.datasourceconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author zhuyanli
 * @date 2020/9/15 13:43
 * @description 动态数据源配置
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 使用ThreadLocal维护变量，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
     * 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        // afterPropertiesSet()方法调用时用来将targetDataSources的属性写入resolvedDataSources中的
        super.afterPropertiesSet();
    }

    /**
     * 根据Key获取数据源的信息
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSource.getDataSourceType();
    }

    /**
     * 设置数据源变量
     *
     * @param dataSourceType
     */
    public static void setDataSourceType(String dataSourceType) {
        log.info("=================切换到{}数据源=================", dataSourceType);
        CONTEXT_HOLDER.set(dataSourceType);
    }

    /**
     * 获取数据源变量
     *
     * @return
     */
    public static String getDataSourceType() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清空数据源变量
     */
    public static void clearDataSourceType() {
        CONTEXT_HOLDER.remove();
    }
}
