package com.xsg.sscm.mapper;

import com.xsg.sscm.model.UAdminRole;
import com.xsg.sscm.model.UAdminRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UAdminRoleMapper {
    long countByExample(UAdminRoleExample example);

    int deleteByExample(UAdminRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UAdminRole record);

    int insertSelective(UAdminRole record);

    List<UAdminRole> selectByExample(UAdminRoleExample example);

    UAdminRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UAdminRole record, @Param("example") UAdminRoleExample example);

    int updateByExample(@Param("record") UAdminRole record, @Param("example") UAdminRoleExample example);

    int updateByPrimaryKeySelective(UAdminRole record);

    int updateByPrimaryKey(UAdminRole record);
}