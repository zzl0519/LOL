package com.zhouzhuolin.springbootjpa.service;

import com.zhouzhuolin.springbootjpa.entity.Teacher;
import com.zhouzhuolin.springbootjpa.entity.Tupian;
import com.zhouzhuolin.springbootjpa.utils.PageBean;
import org.springframework.data.domain.Page;

/**
 * @author 徐凤年
 * @site www.zhouzhuolin.com
 * @company 雪中悍刀行
 * @create  2019-12-12 23:25
 */
public interface TupianService {

    public Tupian save(Tupian tupian);
    public void deleteById(Integer id);
    public Tupian findById(Integer id);
    public Page<Tupian> listPager(Tupian tupian, PageBean pageBean);


}
