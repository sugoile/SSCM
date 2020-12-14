package com.xsg.sscm.mapper;

import com.xsg.sscm.model.UStudentCourse;
import com.xsg.sscm.model.UStudentCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UStudentCourseMapper {
    long countByExample(UStudentCourseExample example);

    int deleteByExample(UStudentCourseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UStudentCourse record);

    int insertSelective(UStudentCourse record);

    List<UStudentCourse> selectByExample(UStudentCourseExample example);

    UStudentCourse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UStudentCourse record, @Param("example") UStudentCourseExample example);

    int updateByExample(@Param("record") UStudentCourse record, @Param("example") UStudentCourseExample example);

    int updateByPrimaryKeySelective(UStudentCourse record);

    int updateByPrimaryKey(UStudentCourse record);
}