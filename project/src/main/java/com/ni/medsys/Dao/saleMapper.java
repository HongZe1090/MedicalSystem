package com.ni.medsys.Dao;

import com.ni.medsys.pojo.Category;
import com.ni.medsys.pojo.Sale;

import java.util.List;

public interface saleMapper {
    //查询所有
    List<Sale> getSaleList();
    //增加
    String addSale(Sale sale);
}
