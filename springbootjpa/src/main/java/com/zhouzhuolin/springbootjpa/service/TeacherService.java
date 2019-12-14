package com.zhouzhuolin.springbootjpa.service;

import com.zhouzhuolin.springbootjpa.entity.Teacher;
import com.zhouzhuolin.springbootjpa.utils.PageBean;
import org.springframework.data.domain.Page;

/**
 * @author 徐凤年
 * @site www.zhouzhuolin.com
 * @company 雪中悍刀行
 * @create  2019-12-01 20:16
 */

public interface TeacherService {

    public Teacher save(Teacher teacher);
    public void deleteById(Integer id);
    public Teacher findById(Integer id);
    public Page<Teacher> listPager(Teacher teacher, PageBean pageBean);


}
