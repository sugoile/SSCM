package com.xsg.sscm.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.dto
 * @author: xsg
 * @date: 2020/10/30
 **/
@Getter
@Setter
public class ApiParentParam {

    private Long value;

    private String apiName;

    private List<ApiParentParam> children;
}
