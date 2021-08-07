package com.tian.springboot_url.mapper;

import com.tian.springboot_url.pojo.AppUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Package: com.tian.springboot_url.mapper
 * Description： TODO
 * Author: 智龙
 * Date: Created in 2021/8/7 10:37
 * Company: China
 * Copyright: Copyright (c) 2021
 * Modified By: SmartDragon
 */
@Mapper
public interface AppUserMapper {

    @Select("select id from app_user")
    List<AppUser> list();
}
