package com.zhouzhuolin.springbootjpa.service.impl;

import com.zhouzhuolin.springbootjpa.entity.Teacher;
import com.zhouzhuolin.springbootjpa.repository.TeacherDao;
import com.zhouzhuolin.springbootjpa.service.TeacherService;
import com.zhouzhuolin.springbootjpa.utils.PageBean;
import com.zhouzhuolin.springbootjpa.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public Teacher save(Teacher teacher) {
        return teacherDao.save(teacher);
    }

    @Override
    public void deleteById(Integer id) {
        teacherDao.deleteById(id);
    }

    @Override
    public Teacher findById(Integer id) {
        return teacherDao.findById(id).get();
    }

    @Override
    public Page<Teacher> listPager(Teacher teacher, PageBean pageBean) {
//        jpa的Pageable分页是从0页码开始
        Pageable pageable = PageRequest.of(pageBean.getPage()-1, pageBean.getRows());
        return teacherDao.findAll(new Specification<Teacher>() {
            @Override
            public Predicate toPredicate(Root<Teacher> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if(teacher != null){
                    if(StringUtils.isNotBlank(teacher.getTname())){
                        predicate.getExpressions().add(criteriaBuilder.like(root.get("tname"),"%"+teacher.getTname()+"%"));
                    }
                }
                return predicate;
            }
        },pageable);
    }
}