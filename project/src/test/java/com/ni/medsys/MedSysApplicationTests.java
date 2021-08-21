package com.ni.medsys;

import com.ni.medsys.Dao.cateMapper;
import com.ni.medsys.Dao.drugMapper;
import com.ni.medsys.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;


@SpringBootTest
class MedSysApplicationTests {

    @Autowired
    private drugMapper drugMapper;

    @Test
    void contextLoads() {
        Category cate = new Category();
        cate.setId("2005");
        cate.setcName("蟑螂药");
        cate.setCreateTime(new Date(2019,8,19));
        cate.setDescription("被蟑螂咬了就吃这个");
        System.out.println(drugMapper.getDrugList());
    }

}
