package com.xsg.sscm.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @des:
 * @package: com.xsg.sscm.dto
 * @author: xsg
 * @date: 2020/12/14
 **/
@Getter
@Setter
public class RandID {
    private int result;
    private Long id;
    private int type;  //0->学生；1->教师
}
