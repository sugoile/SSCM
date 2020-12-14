package com.xsg.sscm.service;

import com.xsg.sscm.dto.CourseInfo;
import com.xsg.sscm.dto.CourseParam;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.service
 * @author: xsg
 * @date: 2020/9/5
 **/
public interface CourseService {
    int AddCourse(CourseParam courseParam);

    List<CourseInfo> getCourse(String query, Integer pageSize, Integer pageNum);

    int UpdateCourse(Long id, CourseParam courseParam);

    int Delete(List<Long> ids);

    int DeleteOne(Long id);

    int UpdateStates(Long ID, Integer State);

    //List<UCourse> getCourseNoSelect();
}
