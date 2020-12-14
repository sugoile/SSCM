package com.xsg.sscm.dao;

import com.xsg.sscm.dto.CourseInfo;
import com.xsg.sscm.dto.TeacherInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.dao
 * @author: xsg
 * @date: 2020/12/13
 **/
public interface CourseDao {
    List<CourseInfo> getCourse(@Param(value = "query") String query);
}
