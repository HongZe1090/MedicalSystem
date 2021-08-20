package com.ni.medsys.Dao;

import com.ni.medsys.pojo.Drug;
import com.ni.medsys.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface managerMapper {
    //    CURD
    //查询所有
    List<Manager> getManagerList();

    //查询单个，字段查询上层再封装
    Manager getManagerSingle(@Param("col") String col, @Param("obValue") String obValue);

    //增加
    String addManager(Manager manager);

    //删除
    String deleteManager(@Param("id") String id);

    //修改
    String updateManager(Manager manager);
}