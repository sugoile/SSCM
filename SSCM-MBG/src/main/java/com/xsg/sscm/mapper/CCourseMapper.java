package com.xsg.sscm.mapper;

import com.xsg.sscm.model.CCourse;
import com.xsg.sscm.model.CCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CCourseMapper {
    long countByExample(CCourseExample example);

    int deleteByExample(CCourseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CCourse record);

    int insertSelective(CCourse record);

    List<CCourse> selectByExample(CCourseExample example);

    CCourse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CCourse record, @Param("example") CCourseExample example);

    int updateByExample(@Param("record") CCourse record, @Param("example") CCourseExample example);

    int updateByPrimaryKeySelective(CCourse record);

    int updateByPrimaryKey(CCourse record);
}