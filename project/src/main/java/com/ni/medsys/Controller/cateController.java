package com.ni.medsys.Controller;

import com.ni.medsys.Dao.cateMapper;
import com.ni.medsys.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
public class cateController {

    @Autowired
    private cateMapper catemapper;

    @GetMapping("/queryAllCate")
    @CrossOrigin
    public List<Category> queryAllCate(){
        List<Category> cateList = catemapper.getCateList();
        return cateList;
    }

    @GetMapping("/querySingleCate/{col}/{obValue}")
    @CrossOrigin
    public Category getCate(@PathVariable("col") String col,@PathVariable("obValue") String obValue){
        Category result = catemapper.getCateSingle(col,obValue);
        return result;
    }

    @GetMapping("/deleteCate/{id}")
    @CrossOrigin
    public String deletebyId(@PathVariable("id") String id){
        System.out.println(id);
        String reult = catemapper.deleteCate(id);
        return reult;
    }

    @GetMapping("/addCate")
    @CrossOrigin
    public String addCate(Category cate){
        System.out.println(cate);
        String reult = catemapper.addCate(cate);
        return reult;
    }

    @GetMapping("/updateCate/{cate}")
    @CrossOrigin
    public String updaCate(@PathVariable("cate") Category cate){
        String reult = catemapper.updateCate(cate);
        return reult;
    }
}
