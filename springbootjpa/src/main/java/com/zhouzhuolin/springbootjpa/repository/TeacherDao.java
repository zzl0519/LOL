package com.zhouzhuolin.springbootjpa.repository;

import com.zhouzhuolin.springbootjpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 只要继承JpaRepository，通常所用的增删查改方法都有
 *  第一个参数：操作的实体类
 *  第二个参数：实体类对应数据表的主键
 *
 *  要使用高级查询必须继承
 * org.springframework.data.jpa.repository.JpaSpecificationExecutor<T>接口
 */
public interface TeacherDao extends JpaRepository<Teacher, Integer>, JpaSpecificationExecutor<Teacher> {
}
