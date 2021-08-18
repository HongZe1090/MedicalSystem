package com.ni.medsys.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Data
@Repository
public class Drug {
  private String Id;
  private String dNode;
  private String dName;
  private int price;
  private int stockCount;
  private Date productionDate;
  private String manufacturer;
  private String categoryId;
}
