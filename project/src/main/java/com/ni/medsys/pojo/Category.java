package com.ni.medsys.pojo;

import lombok.Data;

import java.sql.Date;

@Data
public class Category {
  private String id;
  private String cName;
  private Date createTime;
  private String description;
}
