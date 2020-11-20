package com.xsg.sscm.mapper;

import com.xsg.sscm.model.DDepartment;
import com.xsg.sscm.model.DDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DDepartmentMapper {
    long countByExample(DDepartmentExample example);

    int deleteByExample(DDepartmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DDepartment record);

    int insertSelective(DDepartment record);

    List<DDepartment> selectByExample(DDepartmentExample example);

    DDepartment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DDepartment record, @Param("example") DDepartmentExample example);

    int updateByExample(@Param("record") DDepartment record, @Param("example") DDepartmentExample example);

    int updateByPrimaryKeySelective(DDepartment record);

    int updateByPrimaryKey(DDepartment record);
}