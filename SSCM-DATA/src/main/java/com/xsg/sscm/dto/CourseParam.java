package com.xsg.sscm.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @des:
 * @package: com.xsg.sscm.dto
 * @author: xsg
 * @date: 2020/12/13
 **/
@Getter
@Setter
public class CourseParam {
    private String name;

    private Integer credit;

    private Integer classHours;

    private String planType;

    private String teachingClass;

    private Long tid;

    private Integer limitedElection;

    private Integer classNumber;

    private Integer chooseNumber;

    private Integer stauts;
}
