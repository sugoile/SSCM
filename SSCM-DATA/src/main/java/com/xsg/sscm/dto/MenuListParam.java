package com.xsg.sscm.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @des:
 * @package: com.xsg.sscm.dto
 * @author: xsg
 * @date: 2020/10/21
 **/
@Getter
@Setter
public class MenuListParam {
    private Long id;

    private String fontMenuName;

    private Integer sort;

    private String path;

    private String fontIcon;

    private String description;
}
