package com.xsg.sscm.dto;

import com.xsg.sscm.model.DDepartment;
import com.xsg.sscm.model.DInstitution;
import com.xsg.sscm.po.StaffPO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.dto
 * @author: xsg
 * @date: 2020/11/7
 **/
@Getter
@Setter
public class DepartmentParam {

    private Long id;

    private String dName;

    private Long affiliiatedInstitution;

    private List<StaffPO> Staff;

    private DInstitution Institution;
}
