package com.xsg.sscm.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.xsg.sscm.dao.StudentDao;
import com.xsg.sscm.dto.StudentInfo;
import com.xsg.sscm.dto.StudentParam;
import com.xsg.sscm.mapper.UStudentMapper;
import com.xsg.sscm.mapper.UUserMapper;
import com.xsg.sscm.model.UStudent;
import com.xsg.sscm.model.UStudentExample;
import com.xsg.sscm.model.UUser;
import com.xsg.sscm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private StudentDao studentDao;

    public int AddStudent(StudentParam student) {
        UStudentExample uStudentExample = new UStudentExample();
        uStudentExample.createCriteria().andSnoEqualTo(student.getSno());
        if(uStudentMapper.selectByExample(uStudentExample).size() > 0){
            return -1;
        }
        UStudent uStudent = new UStudent();
        BeanUtil.copyProperties(student, uStudent);
        uStudent.setId(null);
        uStudent.setCreateTime(new Date());
        uStudent.setStatus(1);
        String Password = passwordEncoder.encode(student.getPassword());
        uStudent.setPassword(Password);
        System.out.println(uStudent);
        return uStudentMapper.insertSelective(uStudent);
    }

    @Override
    public List<StudentInfo> getStudent(String query, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return studentDao.getStudent(query);
    }

    @Override
    public int UpdateStudent(Long id, StudentParam studentParam) {
        UStudentExample uStudentExample = new UStudentExample();
        uStudentExample.createCriteria().andSnoEqualTo(studentParam.getSno());
        List<UStudent> uStudents = uStudentMapper.selectByExample(uStudentExample);
        if(uStudents.size() > 0 && uStudents.get(0).getId() != id){
            return -1;
        }
        else{
            UStudent uStudent = new UStudent();
            BeanUtil.copyProperties(studentParam, uStudent);
            uStudent.setId(id);
            uStudent.setPassword(null);
            uStudent.setCreateTime(null);
            uStudent.setStatus(null);
            uStudent.setLoginTime(null);
            return uStudentMapper.updateByPrimaryKeySelective(uStudent);
        }
    }

    @Override
    public int Delete(List<Long> ids) {
        UStudentExample uStudentExample = new UStudentExample();
        uStudentExample.createCriteria().andIdIn(ids);
        return uStudentMapper.deleteByExample(uStudentExample);
    }

    @Override
    public int DeleteOne(Long id) {
        return uStudentMapper.deleteByPrimaryKey(id);
    }
}
