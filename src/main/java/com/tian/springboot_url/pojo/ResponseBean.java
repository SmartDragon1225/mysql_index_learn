package com.tian.springboot_url.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.pagehelper.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * Package: com.tian.springboot_url.pojo
 * Description： TODO
 * Author: 智龙
 * Date: Created in 2021/8/7 10:47
 * Company: China
 * Copyright: Copyright (c) 2021
 * Modified By: SmartDragon
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBean {

    private Integer code;
    private String message;
    private Object data;
}