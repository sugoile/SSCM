package com.xsg.sscm.mapper;

import com.xsg.sscm.model.DPosition;
import com.xsg.sscm.model.DPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DPositionMapper {
    long countByExample(DPositionExample example);

    int deleteByExample(DPositionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DPosition record);

    int insertSelective(DPosition record);

    List<DPosition> selectByExample(DPositionExample example);

    DPosition selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DPosition record, @Param("example") DPositionExample example);

    int updateByExample(@Param("record") DPosition record, @Param("example") DPositionExample example);

    int updateByPrimaryKeySelective(DPosition record);

    int updateByPrimaryKey(DPosition record);
}