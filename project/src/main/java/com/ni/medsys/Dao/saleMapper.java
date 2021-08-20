package com.ni.medsys.Dao;

import com.ni.medsys.pojo.Category;
import com.ni.medsys.pojo.Sale;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface saleMapper {
    //查询所有
    List<Sale> getSaleList();
    //增加
    String addSale(Sale sale);
}
