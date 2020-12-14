package com.xsg.sscm.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.xsg.sscm.dao.TeacherDao;
import com.xsg.sscm.dto.TeacherInfo;
import com.xsg.sscm.dto.TeacherParam;
import com.xsg.sscm.mapper.UTeacherMapper;
import com.xsg.sscm.model.UTeacher;
import com.xsg.sscm.model.UTeacherExample;
import com.xsg.sscm.service.TeacherService;
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
public class TeacherServiceImp implements TeacherService {

    @Autowired
    private UTeacherMapper uTeacherMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TeacherDao TeacherDao;

    public int AddTeacher(TeacherParam teacher) {
        UTeacherExample uTeacherExample = new UTeacherExample();
        uTeacherExample.createCriteria().andTnoEqualTo(teacher.getTno());
        if(uTeacherMapper.selectByExample(uTeacherExample).size() > 0){
            return -1;
        }
        UTeacher uTeacher = new UTeacher();
        BeanUtil.copyProperties(teacher, uTeacher);
        uTeacher.setId(null);
        uTeacher.setCreateTime(new Date());
        uTeacher.setStatus(1);
        String Password = passwordEncoder.encode(teacher.getPassword());
        uTeacher.setPassword(Password);
        System.out.println(uTeacher);
        return uTeacherMapper.insertSelective(uTeacher);
    }

    @Override
    public List<TeacherInfo> getTeacher(String query, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return TeacherDao.getTeacher(query);
    }

    @Override
    public int UpdateTeacher(Long id, TeacherParam TeacherParam) {
        UTeacherExample uTeacherExample = new UTeacherExample();
        uTeacherExample.createCriteria().andTnoEqualTo(TeacherParam.getTno());
        List<UTeacher> uTeachers = uTeacherMapper.selectByExample(uTeacherExample);
        if(uTeachers.size() > 0 && uTeachers.get(0).getId() != id){
            return -1;
        }
        else{
            UTeacher uTeacher = new UTeacher();
            BeanUtil.copyProperties(TeacherParam, uTeacher);
            uTeacher.setId(id);
            uTeacher.setPassword(null);
            uTeacher.setCreateTime(null);
            uTeacher.setStatus(null);
            uTeacher.setLoginTime(null);
            return uTeacherMapper.updateByPrimaryKeySelective(uTeacher);
        }
    }

    @Override
    public int Delete(List<Long> ids) {
        UTeacherExample uTeacherExample = new UTeacherExample();
        uTeacherExample.createCriteria().andIdIn(ids);
        return uTeacherMapper.deleteByExample(uTeacherExample);
    }

    @Override
    public int DeleteOne(Long id) {
        return uTeacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UTeacher> getTeacherNoSelect() {
        return uTeacherMapper.selectByExample(new UTeacherExample());
    }
}
