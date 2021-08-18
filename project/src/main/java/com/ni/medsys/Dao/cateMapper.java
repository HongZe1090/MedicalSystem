package com.ni.medsys.Dao;

import com.ni.medsys.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface cateMapper {
//    CURD
    //查询所有
    List<Category> getCateList();

    //查询单个，字段查询上层再封装
    Category getCateSingle(Category category);

    //增加
    int addCate(Category category);

    //删除
    int deleteCate(Category category);

    //修改
    int updateCate(Category category);
}
