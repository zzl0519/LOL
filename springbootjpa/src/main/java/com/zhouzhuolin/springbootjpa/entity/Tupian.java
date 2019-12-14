package com.zhouzhuolin.springbootjpa.entity;

import lombok.ToString;

import javax.persistence.*;

/**
 * @author 徐凤年
 * @site www.zhouzhuolin.com
 * @company 雪中悍刀行
 * @create  2019-12-12 23:22
 */

@Entity
@Table(name = "tupian")
@ToString
public class Tupian {

    @Id
    @GeneratedValue
    private Integer tid;
    @Column(length = 200)
    private String tname;

    public Tupian(String tname) {
        this.tname = tname;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
