package com.xsg.sscm.service;

import com.xsg.sscm.dto.*;
import com.xsg.sscm.model.UStudent;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.service
 * @author: xsg
 * @date: 2020/12/14
 **/
public interface SORTService {
    RandID UserLogin(SORTLoginParam sortLoginParam);

    StudentInfo getStudentByID(Long id);

    TeacherInfo getTeacherByID(Long id);

    SCResult getCourceByID(Long id);

    List<CourseInfo> getChooseCourceByID(Long id);

    int chooseCource(Long id, Long courseid);

    int NochooseCourse(Long id, Long courseid);

    List<CourseInfo> getCourceByTID(Long tid);

    List<StudentInfo> getChooseCourceByCID(Long cid, Long tid);

    int ScoreToS(Long Tid, Long Sid, Long Cid, Integer score);
}
