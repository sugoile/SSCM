package com.xsg.sscm.mapper;

import com.xsg.sscm.model.URoleApi;
import com.xsg.sscm.model.URoleApiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface URoleApiMapper {
    long countByExample(URoleApiExample example);

    int deleteByExample(URoleApiExample example);

    int deleteByPrimaryKey(Long id);

    int insert(URoleApi record);

    int insertSelective(URoleApi record);

    List<URoleApi> selectByExample(URoleApiExample example);

    URoleApi selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") URoleApi record, @Param("example") URoleApiExample example);

    int updateByExample(@Param("record") URoleApi record, @Param("example") URoleApiExample example);

    int updateByPrimaryKeySelective(URoleApi record);

    int updateByPrimaryKey(URoleApi record);
}