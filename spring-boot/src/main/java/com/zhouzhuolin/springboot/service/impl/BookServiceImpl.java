package com.zhouzhuolin.springboot.service.impl;

import com.zhouzhuolin.springboot.entity.Book;
import com.zhouzhuolin.springboot.mapper.BookMapper;
import com.zhouzhuolin.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 徐凤年
 * @site www.zhouzhuolin.com
 * @company 雪中悍刀行
 * @create  2019-11-28 0:56
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public int deleteByPrimaryKey(Integer bid) {
        return bookMapper.deleteByPrimaryKey(bid);
    }

    @Override
    public int insert(Book record) {
        return bookMapper.insert(record);
    }

    @Override
    public int insertSelective(Book record) {
        return bookMapper.insertSelective(record);
    }

    @Override
    public Book selectByPrimaryKey(Integer bid) {
        return bookMapper.selectByPrimaryKey(bid);
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return bookMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return bookMapper.updateByPrimaryKeySelective(record);
    }
}
