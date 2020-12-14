package com.xsg.sscm.dao;

import com.xsg.sscm.dto.StudentInfo;
import com.xsg.sscm.dto.TeacherInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.dao
 * @author: xsg
 * @date: 2020/12/13
 **/
public interface TeacherDao {
    List<TeacherInfo> getTeacher(@Param(value = "query") String query);
}
