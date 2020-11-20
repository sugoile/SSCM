package com.xsg.sscm.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.dto
 * @author: xsg
 * @date: 2020/10/25
 **/
@Getter
@Setter
public class ApiTreeParam {
    private Long id;

    private Long pid;

    private String apiName;

    private String apiMethod;

    private String apiUrl;

    private String description;

    private Integer sort;

    private List<ApiTreeParam> children;
}
