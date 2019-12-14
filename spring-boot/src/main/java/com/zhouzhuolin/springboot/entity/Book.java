package com.zhouzhuolin.springboot.entity;

import lombok.ToString;
import sun.plugin2.message.Serializer;

import java.io.Serializable;

@ToString
public class Book implements Serializable {
    private Integer bid;

    private String bname;

    private Float price;

    public Book(Integer bid, String bname, Float price) {
        this.bid = bid;
        this.bname = bname;
        this.price = price;
    }

    public Book() {
        super();
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}