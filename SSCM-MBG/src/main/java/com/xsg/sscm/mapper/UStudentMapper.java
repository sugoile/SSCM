package com.xsg.sscm.mapper;

import com.xsg.sscm.model.UStudent;
import com.xsg.sscm.model.UStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UStudentMapper {
    long countByExample(UStudentExample example);

    int deleteByExample(UStudentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UStudent record);

    int insertSelective(UStudent record);

    List<UStudent> selectByExample(UStudentExample example);

    UStudent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UStudent record, @Param("example") UStudentExample example);

    int updateByExample(@Param("record") UStudent record, @Param("example") UStudentExample example);

    int updateByPrimaryKeySelective(UStudent record);

    int updateByPrimaryKey(UStudent record);
}