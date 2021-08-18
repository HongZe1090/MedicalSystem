package com.ni.medsys.pojo;

import lombok.Data;

import java.sql.Date;


@Data
public class Sale {
    private String saleId;
    private Date saleDate;
    private String dcode;
    private int saleCount;
    private int salePrice;
    private String managerId;
}
