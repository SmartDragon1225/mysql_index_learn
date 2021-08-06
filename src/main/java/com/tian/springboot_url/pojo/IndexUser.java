package com.tian.springboot_url.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Package: com.tian.springboot_url.pojo
 * Description： TODO
 * Author: 智龙
 * Date: Created in 2021/8/5 10:10
 * Company: China
 * Copyright: Copyright (c) 2021
 * Modified By: SmartDragon
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class IndexUser {
    private long id;
    private String name;
    private String email;
    private int gender;
    private int age;
    private Date creat_time;
    private Date update_time;
}
