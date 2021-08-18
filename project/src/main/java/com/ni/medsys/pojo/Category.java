package com.ni.medsys.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Data
@Repository
public class Category {
  private String id;
  private String cName;
  private Date createTime;
  private String description;
}
