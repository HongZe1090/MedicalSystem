package com.ni.medsys.pojo;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class Category {
  private String id;
  private String cName;
  private Date createTime;
  private String description;

  public Category() {
  }

  public Category(String id, String cName, Date createTime, String description) {
    this.id = id;
    this.cName = cName;
    this.createTime = createTime;
    this.description = description;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getcName() {
    return cName;
  }

  public void setcName(String cName) {
    this.cName = cName;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
