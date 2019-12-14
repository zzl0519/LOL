package com.zhouzhuolin.springbootjpa.controller;

import com.zhouzhuolin.springbootjpa.entity.Teacher;
import com.zhouzhuolin.springbootjpa.service.TeacherService;
import com.zhouzhuolin.springbootjpa.utils.PageBean;
import com.zhouzhuolin.springbootjpa.utils.PageUtil;
import com.zhouzhuolin.springbootjpa.utils.StringUtils;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author 小李飞刀
 * @site www.javaxl.com
 * @company
 * @create  2019-02-20 22:15
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/listPager")
    public ModelAndView list(Teacher teacher, HttpServletRequest request){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        ModelAndView modelAndView = new ModelAndView();
        Page<Teacher> teachers = teacherService.listPager(teacher, pageBean);
        modelAndView.addObject("teachers",teachers.getContent());
        pageBean.setTotal(teachers.getTotalElements()+"");
        modelAndView.addObject("pageCode", PageUtil.createPageCode(pageBean)/*.replaceAll("<","<").replaceAll("&gt:",">")*/);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(Teacher teacher){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("sexArr",new String[]{"男","女"});
        if(!(teacher.getTid() == null || "".equals(teacher.getTid()))) {
            Teacher t = teacherService.findById(teacher.getTid());
            modelAndView.addObject("teacher", t);
        }
        return modelAndView;
    }

    @RequestMapping("/sc")
    public ModelAndView sc(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("demo");
        return modelAndView;
    }

    @RequestMapping("/add")
    public String add(Teacher teacher, MultipartFile image){
        try {
            String diskPath = "D://temp/"+image.getOriginalFilename();
            String serverPath = "/uploadImages/"+image.getOriginalFilename();
            if(StringUtils.isNotBlank(image.getOriginalFilename())){
                FileUtils.copyInputStreamToFile(image.getInputStream(),new File(diskPath));
                teacher.setImagePath(serverPath);
            }
            teacherService.save(teacher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/teacher/listPager";
    }


    @RequestMapping("/edit")
    public String edit(Teacher teacher, MultipartFile image){
        String diskPath = "D://temp/"+image.getOriginalFilename();
        String serverPath = "/uploadImages/"+image.getOriginalFilename();
        if(StringUtils.isNotBlank(image.getOriginalFilename())){
            try {
                FileUtils.copyInputStreamToFile(image.getInputStream(),new File(diskPath));
                teacher.setImagePath(serverPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        teacherService.save(teacher);
        return "redirect:/teacher/listPager";
    }

    @RequestMapping("/del/{bid}")
    public String del(@PathVariable(value = "bid") Integer bid){
        teacherService.deleteById(bid);
        return "redirect:/teacher/listPager";
    }
}