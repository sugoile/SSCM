package com.xsg.sscm.mapper;

import com.xsg.sscm.model.UTeacher;
import com.xsg.sscm.model.UTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UTeacherMapper {
    long countByExample(UTeacherExample example);

    int deleteByExample(UTeacherExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UTeacher record);

    int insertSelective(UTeacher record);

    List<UTeacher> selectByExample(UTeacherExample example);

    UTeacher selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UTeacher record, @Param("example") UTeacherExample example);

    int updateByExample(@Param("record") UTeacher record, @Param("example") UTeacherExample example);

    int updateByPrimaryKeySelective(UTeacher record);

    int updateByPrimaryKey(UTeacher record);
}