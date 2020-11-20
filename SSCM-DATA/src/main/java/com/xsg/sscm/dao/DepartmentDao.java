package com.xsg.sscm.dao;

import com.xsg.sscm.dto.DepartmentParam;
import com.xsg.sscm.model.DDepartment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.dao
 * @author: xsg
 * @date: 2020/11/7
 **/
public interface DepartmentDao {
    List<DepartmentParam> getDepartmentList(@Param(value="query") String query);
}
