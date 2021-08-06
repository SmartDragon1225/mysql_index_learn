package com.tian.springboot_url.mapper;

import com.tian.springboot_url.pojo.IndexUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Package: com.tian.springboot_url.mapper
 * Description： TODO
 * Author: 智龙
 * Date: Created in 2021/8/5 10:13
 * Company: China
 * Copyright: Copyright (c) 2021
 * Modified By: SmartDragon
 */
@Mapper
public interface IndexUserMapper {
    List<IndexUser> list();

    IndexUser selectbyid(long id);
    IndexUser selectbyname(String name);
    IndexUser selectbygender(int genter);


}
