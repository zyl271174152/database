package com.zyl.database.mapper;

import com.zyl.database.table.WorkOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * @author zhuyanli
 * @date 2021/1/23 16:44
 * @description 文件形式
 */
@Repository
@Mapper
public interface WriteMapper {

    @Select("select * from work_order")
    List<WorkOrder> getList();
}
