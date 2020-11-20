package com.xsg.sscm.mapper;

import com.xsg.sscm.model.DDeparmentStaff;
import com.xsg.sscm.model.DDeparmentStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DDeparmentStaffMapper {
    long countByExample(DDeparmentStaffExample example);

    int deleteByExample(DDeparmentStaffExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DDeparmentStaff record);

    int insertSelective(DDeparmentStaff record);

    List<DDeparmentStaff> selectByExample(DDeparmentStaffExample example);

    DDeparmentStaff selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DDeparmentStaff record, @Param("example") DDeparmentStaffExample example);

    int updateByExample(@Param("record") DDeparmentStaff record, @Param("example") DDeparmentStaffExample example);

    int updateByPrimaryKeySelective(DDeparmentStaff record);

    int updateByPrimaryKey(DDeparmentStaff record);
}