package com.xsg.sscm.mapper;

import com.xsg.sscm.model.UApi;
import com.xsg.sscm.model.UApiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UApiMapper {
    long countByExample(UApiExample example);

    int deleteByExample(UApiExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UApi record);

    int insertSelective(UApi record);

    List<UApi> selectByExample(UApiExample example);

    UApi selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UApi record, @Param("example") UApiExample example);

    int updateByExample(@Param("record") UApi record, @Param("example") UApiExample example);

    int updateByPrimaryKeySelective(UApi record);

    int updateByPrimaryKey(UApi record);
}