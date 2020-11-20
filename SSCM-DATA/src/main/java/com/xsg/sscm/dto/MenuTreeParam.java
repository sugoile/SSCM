package com.xsg.sscm.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.dto
 * @author: xsg
 * @date: 2020/10/21
 **/
@Getter
@Setter
public class MenuTreeParam {
    private Long id;

    private String fontMenuName;

    private Long pid;

    private Integer sort;

    private String path;

    private String fontIcon;

    private String description;

    private List<MenuListParam> children;
}
