package com.xsg.sscm.mapper;

import com.xsg.sscm.model.CSelection;
import com.xsg.sscm.model.CSelectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CSelectionMapper {
    long countByExample(CSelectionExample example);

    int deleteByExample(CSelectionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CSelection record);

    int insertSelective(CSelection record);

    List<CSelection> selectByExample(CSelectionExample example);

    CSelection selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CSelection record, @Param("example") CSelectionExample example);

    int updateByExample(@Param("record") CSelection record, @Param("example") CSelectionExample example);

    int updateByPrimaryKeySelective(CSelection record);

    int updateByPrimaryKey(CSelection record);
}