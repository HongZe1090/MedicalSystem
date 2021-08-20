package com.ni.medsys.Controller;
import com.ni.medsys.Dao.managerMapper;
import com.ni.medsys.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class managerController {

    @Autowired
    private managerMapper managermapper;

    @GetMapping("/queryAllManager")
    @CrossOrigin
    public List<Manager> getManagerList(){
        List<Manager> managerList = managermapper.getManagerList();
        return managerList;
    }

    @GetMapping("/querySingleManager/{col}/{obValue}")
    @CrossOrigin
    public Manager getManager(@PathVariable("col") String col, @PathVariable("obValue") String obValue){
        Manager result = managermapper.getManagerSingle(col,obValue);
        return result;
    }

    @GetMapping("/deleteManager/{id}")
    @CrossOrigin
    public String deletebyId(@PathVariable("id") String id){
        System.out.println(id);
        String reult = managermapper.deleteManager(id);
        return reult;
    }

    @GetMapping("/updateManager/{Manager}")
    @CrossOrigin
    public String updaManager(@PathVariable("Manager") Manager manager){
        String reult = managermapper.updateManager(manager);
        return reult;
    }

    @GetMapping("/addManager/{Manager}")
    @CrossOrigin
    public String addDrug(@PathVariable("Manager") Manager manager){
        String reult = managermapper.addManager(manager);
        return reult;
    }
}
