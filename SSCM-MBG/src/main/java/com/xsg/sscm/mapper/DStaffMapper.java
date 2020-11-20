package com.xsg.sscm.mapper;

import com.xsg.sscm.model.DStaff;
import com.xsg.sscm.model.DStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DStaffMapper {
    long countByExample(DStaffExample example);

    int deleteByExample(DStaffExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DStaff record);

    int insertSelective(DStaff record);

    List<DStaff> selectByExample(DStaffExample example);

    DStaff selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DStaff record, @Param("example") DStaffExample example);

    int updateByExample(@Param("record") DStaff record, @Param("example") DStaffExample example);

    int updateByPrimaryKeySelective(DStaff record);

    int updateByPrimaryKey(DStaff record);
}