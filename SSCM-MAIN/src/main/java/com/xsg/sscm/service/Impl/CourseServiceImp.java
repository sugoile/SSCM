package com.xsg.sscm.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.xsg.sscm.dao.CourseDao;
import com.xsg.sscm.dto.CourseInfo;
import com.xsg.sscm.dto.CourseParam;
import com.xsg.sscm.dto.TeacherInfo;
import com.xsg.sscm.mapper.CCourseMapper;
import com.xsg.sscm.model.*;
import com.xsg.sscm.service.CourseService;
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
public class CourseServiceImp implements CourseService {

    @Autowired
    private CCourseMapper cCourseMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CourseDao courseDao;

    public int AddCourse(CourseParam courseParam) {
        CCourse cCourse = new CCourse();
        BeanUtil.copyProperties(courseParam, cCourse);
        cCourse.setId(null);
        cCourse.setChooseNumber(0);
        cCourse.setStates(0);
        return cCourseMapper.insertSelective(cCourse);
    }

    @Override
    public List<CourseInfo> getCourse(String query, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return courseDao.getCourse(query);
    }

    @Override
    public int UpdateCourse(Long id, CourseParam courseParam) {
        CCourse cCourse = new CCourse();
        BeanUtil.copyProperties(courseParam, cCourse);
        cCourse.setId(id);
        return cCourseMapper.updateByPrimaryKeySelective(cCourse);
    }

    @Override
    public int Delete(List<Long> ids) {
        CCourseExample cCourseExample = new CCourseExample();
        cCourseExample.createCriteria().andIdIn(ids);
        return cCourseMapper.deleteByExample(cCourseExample);
    }

    @Override
    public int DeleteOne(Long id) {
        return cCourseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int UpdateStates(Long ID, Integer State) {
        CCourse cCourse = new CCourse();
        cCourse.setId(ID);
        cCourse.setStates(State);
        return cCourseMapper.updateByPrimaryKeySelective(cCourse);
    }

}
