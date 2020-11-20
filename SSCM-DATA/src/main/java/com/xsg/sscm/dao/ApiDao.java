package com.xsg.sscm.dao;

import com.xsg.sscm.dto.ApiParentParam;
import com.xsg.sscm.dto.ApiTreeParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.dao
 * @author: xsg
 * @date: 2020/10/25
 **/
public interface ApiDao {
    List<ApiTreeParam> getApiTree();

    List<Long> checkLinkRole(@Param(value = "ApiID") Long ApiID);

    List<ApiParentParam> getOneApi();

    List<ApiParentParam> getTwoApi(@Param(value = "ApiID") Long ApiID);

    int MaxSort(@Param(value = "Pid") Long pid);
}
