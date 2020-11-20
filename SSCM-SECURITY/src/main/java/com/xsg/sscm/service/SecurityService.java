package com.xsg.sscm.service;

import com.xsg.sscm.model.UAdmin;
import com.xsg.sscm.model.UFontMenu;
import com.xsg.sscm.model.URole;
import com.xsg.sscm.po.ApiPO;
import com.xsg.sscm.po.FontMenuPO;

import java.util.Date;
import java.util.List;

/**
 * @des: 用于验证信息security的服务
 * @package: com.xsg.sscm.service
 * @author: xsg
 * @date: 2020/9/21
 **/
public interface SecurityService {
    List<URole> getRolesByUserID(long id);

    List<ApiPO> getApiUrlByUserName(String username);

    boolean CheckLogin(String accountNumber, String password) throws Exception;

    UAdmin GetUserByUsername(String username);

    List<FontMenuPO> getMenusByUserName(String username);

    int updateLoginTime(Long id, Date date);

}
