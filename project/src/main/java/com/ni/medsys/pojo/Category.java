package com.ni.medsys.pojo;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@Component
public class Category {
  private String id;
  private String cName;
  private Date createTime;
  private String description;
}
