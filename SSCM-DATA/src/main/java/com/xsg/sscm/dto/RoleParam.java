package com.xsg.sscm.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * @des: 后台角色参数
 * @package: com.xsg.sscm.dto
 * @author: xsg
 * @date: 2020/10/17
 **/
@Setter
@Getter
public class RoleParam {
    private Long id;

    @NotEmpty(message = "角色名不能为空")
    private String roleName;

    private String description;

}
