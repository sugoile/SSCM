package com.xsg.sscm.po;

import lombok.Getter;
import lombok.Setter;

/**
 * @des: 前端菜单返回
 * @package: com.xsg.sscm.po
 * @author: xsg
 * @date: 2020/9/27
 **/
@Getter
@Setter
public class FontMenuPO {
    private Long id;

    private String fontMenuName;

    private Long pid;

    private Integer sort;

    private String path;

    private String fontIcon;
}
