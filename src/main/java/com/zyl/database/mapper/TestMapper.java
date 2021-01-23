package com.zyl.database.mapper;

import com.zyl.database.table.WorkOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhuyanli
 * @date 2021/1/23 16:58
 * @description  原始xml方式
 */
@Repository
@Mapper
public interface TestMapper {

    List<WorkOrder> queryList();
}
