package com.xsg.sscm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xsg.sscm.dao.DepartmentDao;
import com.xsg.sscm.dto.DepartmentParam;
import com.xsg.sscm.mapper.*;
import com.xsg.sscm.model.*;
import com.xsg.sscm.po.StaffPO;
import com.xsg.sscm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.service.Impl
 * @author: xsg
 * @date: 2020/11/7
 **/
@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DDepartmentMapper dDepartmentMapper;

    @Autowired
    private DStaffMapper dStaffMapper;

    @Autowired
    private DPositionMapper dPositionMapper;

    @Autowired
    private DInstitutionMapper dInstitutionMapper;

    @Autowired
    private DDeparmentStaffMapper dDeparmentStaffMapper;

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<DepartmentParam> getDepartment(String query, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<DepartmentParam> departmentParams = departmentDao.getDepartmentList(query);
        if (departmentParams.size() != 0) {
            for (int i = 0; i < departmentParams.size(); i++) {
                if (departmentParams.get(i).getAffiliiatedInstitution() != null) {
                    DInstitution dInstitution = dInstitutionMapper.selectByPrimaryKey(departmentParams.get(i).getAffiliiatedInstitution());
                    departmentParams.get(i).setInstitution(dInstitution);
                    DDeparmentStaffExample dDeparmentStaffExample = new DDeparmentStaffExample();
                    dDeparmentStaffExample.createCriteria().andDepartmentIdEqualTo(departmentParams.get(i).getId());
                    List<DDeparmentStaff> dDeparmentStaffs = dDeparmentStaffMapper.selectByExample(dDeparmentStaffExample);
                    List<StaffPO> staffPOS = new ArrayList<>();
                    if (dDeparmentStaffs.size() != 0) {
                        for (int j = 0; j < dDeparmentStaffs.size(); j++) {
                            StaffPO staffPO = new StaffPO();
                            DStaff dStaff = dStaffMapper.selectByPrimaryKey(dDeparmentStaffs.get(j).getStaffId());
                            staffPO.setDStaff(dStaff);
                            DPosition dPosition = dPositionMapper.selectByPrimaryKey(dStaff.getAffiliiatedPosition());
                            staffPO.setDPosition(dPosition);
                            staffPOS.add(staffPO);
                        }
                    }
                    departmentParams.get(i).setStaff(staffPOS);
                }
            }
        }
        return departmentParams;
    }
}
