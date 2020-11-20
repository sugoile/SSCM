package com.xsg.sscm.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.po
 * @author: xsg
 * @date: 2020/10/7
 **/
@Getter
@Setter
public class FontMenuTreePO {
    private Long id;

    private String fontMenuName;

    private Long pid;

    private Integer sort;

    private String path;

    private String fontIcon;

    private List<FontMenuPO> children;
}
