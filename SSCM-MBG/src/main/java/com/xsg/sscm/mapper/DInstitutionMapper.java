package com.xsg.sscm.mapper;

import com.xsg.sscm.model.DInstitution;
import com.xsg.sscm.model.DInstitutionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DInstitutionMapper {
    long countByExample(DInstitutionExample example);

    int deleteByExample(DInstitutionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DInstitution record);

    int insertSelective(DInstitution record);

    List<DInstitution> selectByExample(DInstitutionExample example);

    DInstitution selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DInstitution record, @Param("example") DInstitutionExample example);

    int updateByExample(@Param("record") DInstitution record, @Param("example") DInstitutionExample example);

    int updateByPrimaryKeySelective(DInstitution record);

    int updateByPrimaryKey(DInstitution record);
}