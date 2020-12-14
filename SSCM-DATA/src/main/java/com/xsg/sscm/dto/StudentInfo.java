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
public class StudentInfo {
    private Long id;

    private Long sno;

    private String name;

    private Long deptid;

    private String dName;

    private String classes;

    private String grade;

    private String campus;

    private Integer studentStatus;

    private Integer studyStatus;

    private String  admissionTime;

    private String password;

    private String createTime;

    private String loginTime;

    private String score;
}
