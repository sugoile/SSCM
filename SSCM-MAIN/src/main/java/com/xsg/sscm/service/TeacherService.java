package com.xsg.sscm.service;

import com.xsg.sscm.dto.TeacherInfo;
import com.xsg.sscm.dto.TeacherParam;
import com.xsg.sscm.model.UTeacher;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.service
 * @author: xsg
 * @date: 2020/9/5
 **/
public interface TeacherService {
    int AddTeacher(TeacherParam uTeacher);

    List<TeacherInfo> getTeacher(String query, Integer pageSize, Integer pageNum);

    int UpdateTeacher(Long id, TeacherParam TeacherParam);

    int Delete(List<Long> ids);

    int DeleteOne(Long id);

    List<UTeacher> getTeacherNoSelect();
}
