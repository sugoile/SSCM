package com.xsg.sscm.po;

import com.xsg.sscm.model.DPosition;
import com.xsg.sscm.model.DStaff;
import lombok.Getter;
import lombok.Setter;

/**
 * @des:
 * @package: com.xsg.sscm.po
 * @author: xsg
 * @date: 2020/11/7
 **/
@Getter
@Setter
public class StaffPO {

    private DStaff dStaff;

    private DPosition dPosition;
}
