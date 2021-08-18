package com.ni.medsys.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Manager {
   private String id;
   private String userName;
   private String passWord;
   private String fullName;
   private String movePhone;
   private int managerType;
}
