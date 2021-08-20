package com.ni.medsys.Controller;

import com.ni.medsys.Dao.saleMapper;
import com.ni.medsys.pojo.Manager;
import com.ni.medsys.pojo.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class saleController {

    @Autowired //相当于实例化
    private saleMapper salemapper;

    @GetMapping("/queryAllSale")
    @CrossOrigin
    public List<Sale> getSaleList(){
        List<Sale> saleList = salemapper.getSaleList();
        return saleList;
    }

    @GetMapping("/addSale/{Sale}")
    @CrossOrigin
    public String addSale(@PathVariable("Sale") Sale sale){
        String reult = salemapper.addSale(sale);
        return reult;
    }



}
