package com.xsg.sscm.mapper;

import com.xsg.sscm.model.CCourseScore;
import com.xsg.sscm.model.CCourseScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CCourseScoreMapper {
    long countByExample(CCourseScoreExample example);

    int deleteByExample(CCourseScoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CCourseScore record);

    int insertSelective(CCourseScore record);

    List<CCourseScore> selectByExample(CCourseScoreExample example);

    CCourseScore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CCourseScore record, @Param("example") CCourseScoreExample example);

    int updateByExample(@Param("record") CCourseScore record, @Param("example") CCourseScoreExample example);

    int updateByPrimaryKeySelective(CCourseScore record);

    int updateByPrimaryKey(CCourseScore record);
}