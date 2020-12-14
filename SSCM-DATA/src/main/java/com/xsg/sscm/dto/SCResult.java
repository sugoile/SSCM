package com.xsg.sscm.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.dto
 * @author: xsg
 * @date: 2020/12/14
 **/
@Getter
@Setter
public class SCResult {
    private int result;
    private String message;
    private List<CourseInfo> courseInfo;
}
