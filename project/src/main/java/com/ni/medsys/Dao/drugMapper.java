package com.ni.medsys.Dao;

import com.ni.medsys.pojo.Drug;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface drugMapper {
    //    CURD
    //查询所有
    List<Drug> getDrugList();

    //查询单个，字段查询上层再封装
    Drug getDrugSingle(@Param("col") String col, @Param("obValue") String obValue);

    //增加
    String addDrug(Drug drug);

    //删除
    String deleteDrug(@Param("id") String id);

    //修改
    String updateDrug(Drug drug);
}