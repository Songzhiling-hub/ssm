package com.yourname.ssm.student.controller;

import com.yourname.ssm.student.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StuController {
    @Autowired
    private StuService stuService;

    /*获取页面*/
    @RequestMapping("/getJsp")
    public ModelAndView getJsp(){
        Map<String,Object> param = stuService.getParam();
        System.out.println(param);
        ModelAndView mdv = new ModelAndView();
        mdv.setViewName("student/stuSaveOrUpate");
        mdv.addObject("p",param);// param----proList、clazList
        return mdv;
    }
    /*saveOrUpdate*/
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(@RequestParam Map<String,Object> param){//通过@RequestParam注解将表单中的参数转换为map集合
        System.out.println(param);
        //保存数据
        int i = stuService.saveOrUpdate(param);

        return "forward:/student/getListJsp/1";//forward: 转发的地址
    }

    /*更新  更新id为xxxx的数据*/
    @RequestMapping("/getUpdateJsp/{id}")
    public ModelAndView getUpdateJsp(@PathVariable("id") String id){
        //专业列表 班级列表
        Map<String,Object> param = stuService.getParam();
        //获取id=xxx的数据
        Map<String, Object> map = stuService.getObject(id);
        //返回页面
        ModelAndView mdv = new ModelAndView();
        mdv.setViewName("student/stuSaveOrUpate");
        mdv.addObject("obj",map);
        mdv.addObject("p",param);// param----proList、clazList

        return mdv;
    }

    /*获取list页面*/
    @RequestMapping("/getListJsp/{curPage}")
    public ModelAndView getListPage(@PathVariable("curPage") int curPage){
        //查询student列表
        Map<String,Object> map = stuService.getList(5, curPage);

        ModelAndView mdv = new ModelAndView("student/list");
        mdv.addObject("p",map);
        return mdv;
    }

    /*删除*/
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        int i = stuService.delete(id);
        return "forward:/student/getListJsp/1";//forward: 转发的地址
    }

    /*详情*/
    @RequestMapping("/getDetail/{id}")
    public ModelAndView getDetailJsp(@PathVariable("id") String id){
        //专业列表 班级列表
        Map<String,Object> param = stuService.getParam();
        //获取id=xxx的数据
        Map<String, Object> map = stuService.getObject(id);
        //返回页面
        ModelAndView mdv = new ModelAndView();
        mdv.setViewName("student/stuSaveOrUpate");
        mdv.addObject("obj",map);
        mdv.addObject("p",param);// param----proList、clazList
        //标记为详情
        mdv.addObject("Detail","detail");
        return mdv;
    }
}
