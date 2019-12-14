package com.zhouzhuolin.springboot.mapper;

import com.zhouzhuolin.springboot.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}