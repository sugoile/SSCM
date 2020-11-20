package com.xsg.sscm.service.Impl;

import com.xsg.sscm.mapper.UStudentMapper;
import com.xsg.sscm.model.UStudent;
import com.xsg.sscm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @des:
 * @package: com.xsg.sscm.service.Impl
 * @author: xsg
 * @date: 2020/9/5
 **/
@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private UStudentMapper uStudentMapper;

    public int AddStudent(UStudent uStudent) {
        uStudent.setId(null);
        return uStudentMapper.insertSelective(uStudent);
    }
}
