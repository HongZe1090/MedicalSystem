package com.ni.medsys.Dao;

import com.ni.medsys.pojo.Drug;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface drugMapper {
    //    CURD
    //查询所有
    List<Drug> getDrugList();

    //查询单个，字段查询上层再封装
    Drug getDrugSingle(Drug drug);

    //增加
    int addDrug(Drug drug);

    //删除
    int deleteDrug(Drug drug);

    //修改
    int updateDrug(Drug drug);
}