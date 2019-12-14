package com.zhouzhuolin.springbootjpa.repository;

import com.zhouzhuolin.springbootjpa.entity.Teacher;
import com.zhouzhuolin.springbootjpa.entity.Tupian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 徐凤年
 * @site www.zhouzhuolin.com
 * @company 雪中悍刀行
 * @create  2019-12-12 23:26
 */
public interface TupianDao extends JpaRepository<Tupian, Integer>, JpaSpecificationExecutor<Tupian> {
}
