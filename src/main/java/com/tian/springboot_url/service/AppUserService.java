package com.tian.springboot_url.service;

import com.tian.springboot_url.pojo.AppUser;

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
public interface AppUserService {

    List<AppUser> list(Integer menu,Integer page, Integer limit);
}
