package com.ni.medsys.Controller;
import com.ni.medsys.Dao.drugMapper;
import com.ni.medsys.pojo.Category;
import com.ni.medsys.pojo.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class drugController {

    @Autowired
    private drugMapper drugmapper;

    @GetMapping("/queryAllDrug")
    @CrossOrigin
    public List<Drug> queryAllDrug(){
        List<Drug> DrugList = drugmapper.getDrugList();
        return DrugList;
    }

    @GetMapping("/querySingleDrug/{col}/{obValue}")
    @CrossOrigin
    public Drug getDrug(@PathVariable("col") String col, @PathVariable("obValue") String obValue){
        Drug result = drugmapper.getDrugSingle(col,obValue);
        return result;
    }

    @GetMapping("/deleteDrug/{id}")
    @CrossOrigin
    public String deletebyId(@PathVariable("id") String id){
        System.out.println(id);
        String reult = drugmapper.deleteDrug(id);
        return reult;
    }

    @GetMapping("/updateDrug/{Drug}")
    @CrossOrigin
    public String updadrug(@PathVariable("Drug") Drug drug){
        String reult = drugmapper.updateDrug(drug);
        return reult;
    }

    @GetMapping("/addDrug/{Drug}")
    @CrossOrigin
    public String addDrug(@PathVariable("Drug") Drug drug){
        String reult = drugmapper.addDrug(drug);
        return reult;
    }
}
