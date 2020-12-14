package com.xsg.sscm.dao;

import com.xsg.sscm.dto.StudentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.dao
 * @author: xsg
 * @date: 2020/12/13
 **/
public interface StudentDao {
    List<StudentInfo> getStudent(@Param(value="query") String query);
}
