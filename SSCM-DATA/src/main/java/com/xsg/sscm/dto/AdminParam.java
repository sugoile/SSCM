package com.xsg.sscm.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @des: 后台管理员参数
 * @package: com.xsg.sscm.dto
 * @author: xsg
 * @date: 2020/9/5
 **/
@Getter
@Setter
public class AdminParam {

    private Long id;

    private String username;

    private String email;

    private String nickName;

    private String note;

    private String createTime;

    private String loginTime;

    private Integer status;
}
