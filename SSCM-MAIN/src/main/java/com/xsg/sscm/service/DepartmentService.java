package com.xsg.sscm.service;

import com.xsg.sscm.dto.DepartmentParam;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.service
 * @author: xsg
 * @date: 2020/11/7
 **/
public interface DepartmentService {
    List<DepartmentParam> getDepartment(String query, Integer pageSize, Integer pageNum);
}
