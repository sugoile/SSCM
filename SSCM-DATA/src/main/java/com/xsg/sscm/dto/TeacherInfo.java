package com.xsg.sscm.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @des:
 * @package: com.xsg.sscm.dto
 * @author: xsg
 * @date: 2020/12/13
 **/
@Getter
@Setter
@ToString
public class TeacherInfo {
    private Long id;

    private Long tno;

    private String tname;

    private Integer sex;

    private String education;

    private String position;

    private String maincourse;

    private String secondcourse;

    private Long deptid;

    private String dName;

    private String campus;

    private String password;

    private String createTime;

    private String loginTime;
}
