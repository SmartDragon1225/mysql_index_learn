package com.tian.springboot_url.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Package: com.tian.springboot_url.pojo
 * Description： TODO
 * Author: 田智龙
 * Date: Created in 2021/7/31 16:06
 * Company: 山东理工大学
 * Copyright: Copyright (c) 2021
 * Modified By: SmartDragon
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;
    private String name;
    private int age;
    private String sex;
    private String place;
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
    private Date creat_time;//创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
    private Date updata_time;//更新时间


}
