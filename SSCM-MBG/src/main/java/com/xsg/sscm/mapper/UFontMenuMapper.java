package com.xsg.sscm.mapper;

import com.xsg.sscm.model.UFontMenu;
import com.xsg.sscm.model.UFontMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UFontMenuMapper {
    long countByExample(UFontMenuExample example);

    int deleteByExample(UFontMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UFontMenu record);

    int insertSelective(UFontMenu record);

    List<UFontMenu> selectByExample(UFontMenuExample example);

    UFontMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UFontMenu record, @Param("example") UFontMenuExample example);

    int updateByExample(@Param("record") UFontMenu record, @Param("example") UFontMenuExample example);

    int updateByPrimaryKeySelective(UFontMenu record);

    int updateByPrimaryKey(UFontMenu record);
}