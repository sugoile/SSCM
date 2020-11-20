package com.xsg.sscm.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @des: 注册admin参数
 * @package: com.xsg.sscm.dto
 * @author: xsg
 * @date: 2020/9/6
 **/
@Getter
@Setter
public class AdminRegisterParam {
    @NotEmpty(message = "账号不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;

    private String email;

    @NotEmpty(message = "昵称不能为空")
    private String nickName;

    private String note;

    private Integer status;
}
