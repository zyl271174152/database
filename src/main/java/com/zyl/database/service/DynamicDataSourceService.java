package com.zyl.database.service;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.zyl.database.datasourceconfig.DataSource;
import com.zyl.database.mapper.DynamicDataSourceMapper;
import com.zyl.database.table.WorkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhuyanli
 * @date 2021/1/23 15:27
 * @description 动态数据源
 */

@Service
public class DynamicDataSourceService {
    /**
     * 用于servie层 有效     controller加注解无效
     */
    @DataSource("mysql")
    public void test() {

    }


}
