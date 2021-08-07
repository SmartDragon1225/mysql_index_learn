package com.tian.springboot_url;

import com.tian.springboot_url.mapper.IndexUserMapper;
import com.tian.springboot_url.mapper.StudentMapper;
import com.tian.springboot_url.pojo.IndexUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@Slf4j
@SpringBootTest
class SpringbootUrlApplicationTests {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    IndexUserMapper indexUserMapper;
    @Test
    void contextLoads() {
        studentMapper.list().forEach(System.out::println);
    }
    @Test
    void test(){
        if(studentMapper.login(5,null)!=null)
            System.out.println("ok!");
    }

    @Test
    void list(){
        //用时44s
        long date = System.currentTimeMillis();
        System.out.println(date + "ms");
        indexUserMapper.list();
        long end = System.currentTimeMillis();
        System.out.println((end-date)/1000 + "s");
    }

    @Test
    void selectbyname(){
        //加索引5秒
        long date = System.currentTimeMillis();
        System.out.println(date + "ms");
        System.out.println(indexUserMapper.selectbyname("田智龙"));
        long end = System.currentTimeMillis();
        System.out.println((end-date)/1000 + "s");
    }

    @Test
    void selectbynamenoindex(){
        //不加索引7s
        long date = System.currentTimeMillis();
        System.out.println(date + "ms");
        System.out.println(indexUserMapper.selectbyname("田智龙"));
        long end = System.currentTimeMillis();
        System.out.println((end-date)/1000 + "s");
    }


    @Test
    void selectlist(){
        //不加索引7s
        long date = System.currentTimeMillis();
        System.out.println(date + "ms");
        studentMapper.list().forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.println((end-date)/1000 + "s");
    }

}
