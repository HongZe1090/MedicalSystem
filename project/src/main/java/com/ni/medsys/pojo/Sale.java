package com.ni.medsys.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public class Sale {
    private String saleId;
    private Date saleDate;
    private String dcode;
    private int saleCount;
    private int salePrice;
    private String managerId;

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public String getDcode() {
        return dcode;
    }

    public void setDcode(String dcode) {
        this.dcode = dcode;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public Sale(String saleId, Date saleDate, String dcode, int saleCount, int salePrice, String managerId) {
        this.saleId = saleId;
        this.saleDate = saleDate;
        this.dcode = dcode;
        this.saleCount = saleCount;
        this.salePrice = salePrice;
        this.managerId = managerId;
    }

    public Sale() {
    }
}
