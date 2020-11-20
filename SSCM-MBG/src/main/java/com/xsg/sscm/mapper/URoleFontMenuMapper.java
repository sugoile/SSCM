package com.xsg.sscm.mapper;

import com.xsg.sscm.model.URoleFontMenu;
import com.xsg.sscm.model.URoleFontMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface URoleFontMenuMapper {
    long countByExample(URoleFontMenuExample example);

    int deleteByExample(URoleFontMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(URoleFontMenu record);

    int insertSelective(URoleFontMenu record);

    List<URoleFontMenu> selectByExample(URoleFontMenuExample example);

    URoleFontMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") URoleFontMenu record, @Param("example") URoleFontMenuExample example);

    int updateByExample(@Param("record") URoleFontMenu record, @Param("example") URoleFontMenuExample example);

    int updateByPrimaryKeySelective(URoleFontMenu record);

    int updateByPrimaryKey(URoleFontMenu record);
}