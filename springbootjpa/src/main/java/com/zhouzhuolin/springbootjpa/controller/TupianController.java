package com.zhouzhuolin.springbootjpa.controller;

import com.zhouzhuolin.springbootjpa.entity.Tupian;
import com.zhouzhuolin.springbootjpa.service.TupianService;
import com.zhouzhuolin.springbootjpa.utils.StringUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

/**
 * @author 徐凤年
 * @site www.zhouzhuolin.com
 * @company 雪中悍刀行
 * @create  2019-12-12 23:32
 */
@Controller
@RequestMapping("/tupian")
public class TupianController {

    @Autowired
    private TupianService tupianService;

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(Tupian tupian){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("sexArr",new String[]{"男","女"});
        if(!(tupian.getTid() == null || "".equals(tupian.getTid()))) {
            Tupian byId = tupianService.findById(tupian.getTid());
            modelAndView.addObject("tupian", byId);
        }
        return modelAndView;
    }


    @RequestMapping("/add")
    public String add(Tupian tupian, @RequestParam("file") MultipartFile image){
        try {
            String diskPath = "D://temp/"+image.getOriginalFilename();
            String serverPath = "/uploadImages/"+image.getOriginalFilename();
            if(StringUtils.isNotBlank(image.getOriginalFilename())){
                FileUtils.copyInputStreamToFile(image.getInputStream(),new File(diskPath));
                tupian.setTname(serverPath);
            }
            tupianService.save(tupian);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/tupian/listPager";
    }


    @RequestMapping("/edit")
    public String edit(Tupian tupian, MultipartFile image){
        String diskPath = "D://temp/"+image.getOriginalFilename();
        String serverPath = "/uploadImages/"+image.getOriginalFilename();
        if(StringUtils.isNotBlank(image.getOriginalFilename())){
            try {
                FileUtils.copyInputStreamToFile(image.getInputStream(),new File(diskPath));
                tupian.setTname(serverPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        tupianService.save(tupian);
        return "redirect:/tupian/listPager";
    }

    @RequestMapping("/del/{bid}")
    public String del(@PathVariable(value = "bid") Integer bid){
        tupianService.deleteById(bid);
        return "redirect:/tupian/listPager";
    }



}
