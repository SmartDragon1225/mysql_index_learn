package com.tian.springboot_url.faceExam.JUC;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Package: com.tian.springboot_url.faceExam.JUC
 * Description： TODO
 * Author: 智龙
 * Date: Created in 2021/8/2 10:48
 * Company: China
 * Copyright: Copyright (c) 2021
 * Modified By: SmartDragon
 */
public class MyJUC {

    //线程实现第一种方式
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        }).start();

        /*
        * CAS+synchronized实现，分段锁
        * */
        HashMap<Object, Object> hashMap = new HashMap<>();
        ConcurrentMap<Object, Object> objectObjectConcurrentMap = new ConcurrentHashMap<>();
        //LinkedHashMap<Object, Object> zhangsan = new LinkedHashMap<>();
        JSONObject zhangsan = new JSONObject();
        zhangsan.put("name", "张三");
        zhangsan.put("age", 18.4);
        zhangsan.put("birthday", "1900-20-03");
        zhangsan.put("majar", new String[] {"哈哈","嘿嘿"});
        zhangsan.put("null", null);
        zhangsan.put("house", false);
        System.out.println(zhangsan.toString());
        System.out.println(zhangsan.toString());
        System.out.println(zhangsan.toString());
        System.out.println(zhangsan.toString());
        System.out.println(zhangsan.toString());
        System.out.println(zhangsan.toString());
        System.out.println(JSONObject.toJSONString(zhangsan));

        //PageInfo pageInfo = new PageInfo();
        /*{name=张三, age=18.4, birthday=1900-20-03, majar=[Ljava.lang.String;@6267c3bb, null=null, house=false}
{"name":"张三","age":18.4,"birthday":"1900-20-03","majar":["哈哈","嘿嘿"],"house":false}*/

    }
}
