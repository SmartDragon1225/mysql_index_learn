package com.tian.springboot_url.service;

import com.tian.springboot_url.mapper.AppUserMapper;
import com.tian.springboot_url.pojo.AppUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Package: com.tian.springboot_url.service
 * Description： TODO
 * Author: 智龙
 * Date: Created in 2021/8/7 10:35
 * Company: China
 * Copyright: Copyright (c) 2021
 * Modified By: SmartDragon
 */
@Service
public class AppUserServiceImpl implements AppUserService{

    private static final Logger log = LogManager.getLogger(AppUserServiceImpl.class);
    @Autowired
    private AppUserMapper appUserMapper;

    /**
     * 查询菜单列表(分页)
     * @param menu 为1时只返回菜单类型  其它值时返回所有类型(这里请无视该参数)
     * @return
     */
    /*@Override
    public List<AppUser> getMenus(Integer menu, Integer page, Integer limit) {
        List<AppUser> menuList = null;
        if (menu == 1){
            menuList = menuMapper.selectMenu();
        }else{
            menuList = menuMapper.selectAll();//分页查询执行mapper接口的方法
            //注意一定要用mapper接口调用执行里面的对应方法！！！调用service接口的方法插件识别不了，会报错！！！
        }
        return menuList;
    }*/

    @Override
    public List<AppUser> list(Integer menu, Integer page, Integer limit) {
        List<AppUser> appUserList = null;
        appUserList = appUserMapper.list();
        return appUserList;
    }
}
