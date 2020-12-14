package com.xsg.sscm.service;

import com.xsg.sscm.dto.StudentInfo;
import com.xsg.sscm.dto.StudentParam;
import com.xsg.sscm.model.UStudent;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.service
 * @author: xsg
 * @date: 2020/9/5
 **/
public interface StudentService {
    int AddStudent(StudentParam uStudent);

    List<StudentInfo> getStudent(String query, Integer pageSize, Integer pageNum);

    int UpdateStudent(Long id, StudentParam studentParam);

    int Delete(List<Long> ids);

    int DeleteOne(Long id);
}
