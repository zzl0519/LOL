package com.zhouzhuolin.springboot.service.impl;

import com.zhouzhuolin.springboot.entity.Book;
import com.zhouzhuolin.springboot.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 徐凤年
 * @site www.zhouzhuolin.com
 * @company 雪中悍刀行
 * @create  2019-11-28 0:58
 */
@SpringBootTest
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    public void deleteByPrimaryKey() {

        bookService.deleteByPrimaryKey(12);

    }

    @Test
    public void selectByPrimaryKey() {

        Book book = bookService.selectByPrimaryKey(18);
        System.out.println(book);
        System.out.println("---------------------------------------------");
        Book book2 = bookService.selectByPrimaryKey(18);
        System.out.println(book2);

    }
}