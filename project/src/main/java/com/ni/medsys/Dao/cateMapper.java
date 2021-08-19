package com.ni.medsys.Dao;

import com.ni.medsys.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface cateMapper {
//    CURD
    //查询所有
    List<Category> getCateList();

    //查询单个，字段查询上层再封装
    Category getCateSingle(@Param("col") String col, @Param("obValue") String obValue);

    //增加
    String addCate(Category category);

    //删除
    String deleteCate(@Param("id") String id);

    //修改
    String updateCate(Category category);
}
