package com.zyl.database.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyl.database.table.WorkOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhuyanli
 * @date 2021/1/23 15:29
 * @description  mybatis 插件使用
 */
@Repository
@Mapper
public interface DynamicDataSourceMapper extends BaseMapper<WorkOrder> {
}
