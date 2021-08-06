package com.tian.springboot_url.mapper;

import com.tian.springboot_url.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Package: com.tian.springboot_url.mapper
 * Description： TODO
 * Author: 田智龙
 * Date: Created in 2021/7/31 16:08
 * Company: 山东理工大学
 * Copyright: Copyright (c) 2021
 * Modified By: SmartDragon
 */
@Mapper
public interface StudentMapper {

    //@Select("select * from student")
    List<Student> list();

    //@Delete("delete form stdent where id = #{id}")
    int delete(int id);

    /*@Update("update student set id=#{id},name=#{name},age=#{age},sex=#{sex},place=#{place},\n" +
            "                      creat_time=#{creat_time},updata_time=#{updata_time}\n" +
            "        where id=#{id}")*/
    int update(Student student);

    /*@Insert("insert into student value (#{id},#{name},#{age},#{sex},\n" +
            "            #{place},#{creat_time},#{updata_time})")*/
    int insert(Student student);

    //@Select("select * from student where id = #{id}")
    Student select(int id);

    Student login(int id,String name);
}
