package com.xsg.sscm.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @des:
 * @package: com.xsg.sscm.dto
 * @author: xsg
 * @date: 2020/12/13
 **/
@Getter
@Setter
@ToString
public class TeacherParam {
    private Long tno;

    private String tname;

    private Integer sex;

    private String education;

    private String position;

    private String maincourse;

    private String secondcourse;

    private Long deptid;

    private String campus;

    private String password;
}
