package com.ni.medsys.Dao;

import com.ni.medsys.pojo.Drug;
import com.ni.medsys.pojo.Manager;

public interface managerMapper {
    //查询单个，字段查询上层再封装
    Manager getManagerSingle(Manager manager);

    //修改
    int updateDrug(Manager manager);
}
