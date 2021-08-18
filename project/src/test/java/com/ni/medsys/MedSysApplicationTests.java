package com.ni.medsys;

import com.ni.medsys.Dao.cateMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.activation.DataSource;

@SpringBootTest
class MedSysApplicationTests {

    @Autowired
    private cateMapper cateMapper;

    @Autowired
    DataSource dataSource; //从数据库中取数据源

    @Test
    void contextLoads() {


    }

}
