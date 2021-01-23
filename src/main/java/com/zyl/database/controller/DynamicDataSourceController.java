package com.zyl.database.controller;

import com.zyl.database.mapper.DynamicDataSourceMapper;
import com.zyl.database.mapper.TestMapper;
import com.zyl.database.mapper.WriteMapper;
import com.zyl.database.table.WorkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhuyanli
 * @date 2021/1/22 14:53
 * @description 动态数据源配置
 */
@RestController
public class DynamicDataSourceController {

    @Autowired
    DynamicDataSourceMapper dynamicDataSourceMapper;

    @Autowired
    WriteMapper writeMapper;

    @Autowired
    TestMapper testMapper;

    /**
     * 用插件方法
     *
     * @return
     */
    @GetMapping(path = "/test")
    public List<WorkOrder> test() {
        List<WorkOrder> workOrders = dynamicDataSourceMapper.selectList(null);
        return workOrders;

    }

    /**
     * 注解形式
     *
     * @return
     */
    @GetMapping(path = "/test2")
    public List<WorkOrder> test2() {
        List<WorkOrder> workOrders = writeMapper.getList();
        return workOrders;

    }

    /**
     * xml写sql
     *
     * @return
     */
    @GetMapping(path = "/test3")
    public List<WorkOrder> test3() {
        List<WorkOrder> workOrders = testMapper.queryList();
        return workOrders;

    }
}
