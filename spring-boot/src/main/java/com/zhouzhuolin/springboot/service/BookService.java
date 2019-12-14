package com.zhouzhuolin.springboot.service;

import com.zhouzhuolin.springboot.entity.Book;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author 徐凤年
 * @site www.zhouzhuolin.com
 * @company 雪中悍刀行
 * @create  2019-11-28 0:55
 */
public interface BookService {

    int deleteByPrimaryKey(Integer bid);

    int insert(Book record);

    int insertSelective(Book record);

    @Cacheable(value = "my-redis-cache1",key = "'book'+#bid",condition = "#bid>10")
    Book selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);


}
