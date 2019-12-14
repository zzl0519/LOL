package com.zhouzhuolin.springbootjpa.service.impl;

import com.zhouzhuolin.springbootjpa.entity.Tupian;
import com.zhouzhuolin.springbootjpa.repository.TupianDao;
import com.zhouzhuolin.springbootjpa.service.TupianService;
import com.zhouzhuolin.springbootjpa.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author 徐凤年
 * @site www.zhouzhuolin.com
 * @company 雪中悍刀行
 * @create  2019-12-12 23:26
 */

@Service
public class TupianServiceImpl implements TupianService {

    @Autowired
    private TupianDao tupianDao;

    @Override
    public Tupian save(Tupian tupian) {
        return tupianDao.save(tupian);
    }

    @Override
    public void deleteById(Integer id) {
        tupianDao.deleteById(id);
    }

    @Override
    public Tupian findById(Integer id) {
        return tupianDao.findById(id).get();
    }

    @Override
    public Page<Tupian> listPager(Tupian tupian, PageBean pageBean) {
        return null;
    }
}
