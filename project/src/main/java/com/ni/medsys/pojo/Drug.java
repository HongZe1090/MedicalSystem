package com.ni.medsys.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public class Drug {
  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  private String dCode;
  private String dName;
  private int price;
  private int stockCount;
  private Date productionDate;
  private String manufacturer;
  private String categoryId;

  public Drug() {
  }

  public Drug(String id, String dCode, String dName, int price, int stockCount, Date productionDate, String manufacturer, String categoryId) {
    this.id = id;
    this.dCode = dCode;
    this.dName = dName;
    this.price = price;
    this.stockCount = stockCount;
    this.productionDate = productionDate;
    this.manufacturer = manufacturer;
    this.categoryId = categoryId;
  }



  public String getdCode() {
    return dCode;
  }

  public void setdCode(String dCode) {
    this.dCode = dCode;
  }

  public String getdName() {
    return dName;
  }

  public void setdName(String dName) {
    this.dName = dName;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getStockCount() {
    return stockCount;
  }

  public void setStockCount(int stockCount) {
    this.stockCount = stockCount;
  }

  public Date getProductionDate() {
    return productionDate;
  }

  public void setProductionDate(Date productionDate) {
    this.productionDate = productionDate;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }
}
