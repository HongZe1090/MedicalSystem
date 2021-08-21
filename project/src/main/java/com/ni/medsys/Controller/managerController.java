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

    @GetMapping("/querySingleManager")
    @CrossOrigin
    public Manager getManager(String value){
        System.out.println("555");
//        System.out.println(username+password);
//        Manager result = managermapper.getManagerSingle("id",username);
//        return result;
    }

    @GetMapping("/deleteManager/{id}")
    @CrossOrigin
    public String deletebyId(@PathVariable("id") String id){
        System.out.println(id);
        String reult = managermapper.deleteManager(id);
        return reult;
    }

    @GetMapping("/updateManager")
    @CrossOrigin
    public String updaManager( Manager manager){
        String reult = managermapper.updateManager(manager);
        return reult;
    }

    @GetMapping("/addManager")
    @CrossOrigin
    public String addDrug( Manager manager){
        String reult = managermapper.addManager(manager);
        return reult;
    }
}
