package com.ni.medsys.pojo;

import lombok.Data;

@Data
public class Manager {
   private String id;
   private String userName;
   private String passWord;
   private String fullName;
   private String movePhone;
   private int managerType;
}
