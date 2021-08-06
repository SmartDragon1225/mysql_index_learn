package com.tian.springboot_url.controller;

import com.tian.springboot_url.mapper.StudentMapper;
import com.tian.springboot_url.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Package: com.tian.springboot_url.controller
 * Description： TODO
 * Author: 田智龙
 * Date: Created in 2021/7/31 16:10
 * Company: 山东理工大学
 * Copyright: Copyright (c) 2021
 * Modified By: SmartDragon
 */
@Controller
public class StudentController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @Autowired
    StudentMapper studentMapper;

    @RequestMapping("/student/list")
    @ResponseBody
    List<Student> list(){
        return studentMapper.list();
    }

    @RequestMapping("/student/delete")
    public List<Student> delete(int id){
        studentMapper.delete(id);//删除用户
        return studentMapper.list();
    }

    @RequestMapping("/student/add")
    public List<Student> add(Student student){
        studentMapper.insert(student);
        return studentMapper.list();
    }

    @RequestMapping("/student/update")
    public List<Student> update(Student student){
        studentMapper.update(student);
        return studentMapper.list();
    }

    @RequestMapping("/student/select")
    public Student select(int id){
        return studentMapper.select(id);
    }





























































    static boolean foo(char c)

    {

        System.out.print(c);

        return true;

    }

    public static void main(String[] args) {
        int i =0;
        Object o = new Object();

        for(foo('A');foo('B')&&(i<2);foo('C'))

        {

            i++;

            foo('D');

        }
        new StudentController().go();

        StudentController studentController = new StudentController();
        studentController.list().forEach(System.out::println);
    }
    public void go(){

        Runnable r=new Runnable(){

            public void run(){

                System.out.print("foo");

            }

        };

        Thread t=new Thread(r);

        t.start();

    }
}
