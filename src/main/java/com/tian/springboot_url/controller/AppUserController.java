package com.tian.springboot_url.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tian.springboot_url.config.PageHelperConfig;
import com.tian.springboot_url.pojo.AppUser;
import com.tian.springboot_url.pojo.ResponseBean;
import com.tian.springboot_url.service.AppUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Package: com.tian.springboot_url.controller
 * Description： TODO
 * Author: 智龙
 * Date: Created in 2021/8/7 10:43
 * Company: China
 * Copyright: Copyright (c) 2021
 * Modified By: SmartDragon
 */
@RestController
public class AppUserController {

    private static final Logger log = LogManager.getLogger(AppUserController.class);
    @Autowired
    private AppUserService menuService;

    /**
     * 查询菜单列表
     * @paam menu 为1时只返回菜单类型  其它值时返回所有类型（这里请无视该参数）
     * @return
     */
    @GetMapping("/menu/list/{menu}/{page}/{limit}")
    public ResponseBean getMenus(@PathVariable Integer menu, @PathVariable("page") Integer page, @PathVariable("limit") Integer limit){
        JSONObject map = new JSONObject();//创建JSONmap来存放JSON数据传到前台
        PageHelper.startPage(page -1, limit);//设置数据库分页查询的范围
        List<AppUser> menus = menuService.list(menu, page, limit);//执行service层的方法
        PageInfo<AppUser> pageInfo=new PageInfo<>(menus);
        map.put("count",pageInfo.getTotal());//获取查询总条数，这里我会在后面解释
        map.put("data",menus);
        return new ResponseBean(200,"成功",map);
    }
}
