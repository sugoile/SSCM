package com.xsg.sscm.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.xsg.sscm.dto.*;
import com.xsg.sscm.mapper.*;
import com.xsg.sscm.model.*;
import com.xsg.sscm.service.SORTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.service.Impl
 * @author: xsg
 * @date: 2020/12/14
 **/
@Service
public class SORTServiceImp implements SORTService {

    @Autowired
    private UStudentMapper uStudentMapper;

    @Autowired
    private UTeacherMapper uTeacherMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DDepartmentMapper dDepartmentMapper;

    @Autowired
    private CCourseMapper cCourseMapper;

    @Autowired
    private UStudentCourseMapper uStudentCourseMapper;

    @Autowired
    private CCourseScoreMapper cCourseScoreMapper;


    @Override
    public RandID UserLogin(SORTLoginParam sortLoginParam) {
        RandID randID = new RandID();
        UStudentExample uStudentExample = new UStudentExample();
        uStudentExample.createCriteria().andSnoEqualTo(Long.valueOf(sortLoginParam.getUsername()));
        UTeacherExample uTeacherExample = new UTeacherExample();
        uTeacherExample.createCriteria().andTnoEqualTo(Long.valueOf(sortLoginParam.getUsername()));
        List<UStudent> uStudents = uStudentMapper.selectByExample(uStudentExample);
        List<UTeacher> uTeachers = uTeacherMapper.selectByExample(uTeacherExample);
        if (uStudents.size() == 0 && uTeachers.size() == 0) {
            randID.setResult(-1);
            return randID;   //账号不存在
        } else {
            if (uStudents.size() > 0 && uTeachers.size() == 0) {
                String encodepassword = uStudents.get(0).getPassword();
                if (!passwordEncoder.matches(sortLoginParam.getPassword(), encodepassword)) {
                    randID.setResult(2);
                    return randID;   //密码错误
                } else {
                    UStudent uStudent = new UStudent();
                    uStudent.setId(uStudents.get(0).getId());
                    uStudent.setLoginTime(new Date());
                    uStudentMapper.updateByPrimaryKeySelective(uStudent);
                    randID.setResult(1);
                    randID.setId(uStudents.get(0).getId());
                    randID.setType(0);
                    return randID;  //学生
                }
            } else if (uTeachers.size() > 0 && uStudents.size() == 0) {
                String encodepassword = uTeachers.get(0).getPassword();
                if (!passwordEncoder.matches(sortLoginParam.getPassword(), encodepassword)) {
                    randID.setResult(2);
                    return randID;   //密码错误
                } else {
                    UTeacher uTeacher = new UTeacher();
                    uTeacher.setId(uTeachers.get(0).getId());
                    uTeacher.setLoginTime(new Date());
                    uTeacherMapper.updateByPrimaryKeySelective(uTeacher);
                    randID.setResult(1);
                    randID.setId(uTeachers.get(0).getId());
                    randID.setType(1);
                    return randID;  //教师
                }
            } else {
                randID.setResult(3);
                return randID;  //学生与教师的账号相同（前端限制基本不可能会出现）
            }
        }
    }

    @Override
    public StudentInfo getStudentByID(Long id) {
        UStudent uStudent = uStudentMapper.selectByPrimaryKey(id);
        StudentInfo studentInfo = new StudentInfo();
        String dName = dDepartmentMapper.selectByPrimaryKey(uStudent.getDeptid()).getdName();
        BeanUtil.copyProperties(uStudent, studentInfo);
        studentInfo.setDName(dName);
        return studentInfo;
    }

    @Override
    public TeacherInfo getTeacherByID(Long id) {
        UTeacher uTeacher = uTeacherMapper.selectByPrimaryKey(id);
        TeacherInfo teacherInfo = new TeacherInfo();
        String dName = dDepartmentMapper.selectByPrimaryKey(uTeacher.getDeptid()).getdName();
        BeanUtil.copyProperties(uTeacher, teacherInfo);
        teacherInfo.setDName(dName);
        return teacherInfo;
    }

    @Override
    public SCResult getCourceByID(Long id) {
        SCResult scResult = new SCResult();
        UStudent uStudent = uStudentMapper.selectByPrimaryKey(id);
        if (uStudent.getStudyStatus() == 0) {
            scResult.setMessage("该生无学籍, 无法选课");
            scResult.setResult(0);
            return scResult;
        } else if (uStudent.getStudyStatus() == 0) {
            scResult.setMessage("该生已退学, 无法选课");
            scResult.setResult(0);
            return scResult;
        } else if (uStudent.getStudyStatus() == 2) {
            scResult.setMessage("该生已毕业, 无法选课");
            scResult.setResult(0);
            return scResult;
        } else {
            List<CourseInfo> courseInfos = new ArrayList<>();
            CCourseExample cCourseExample = new CCourseExample();
            cCourseExample.createCriteria().andStatesEqualTo(1);
            List<CCourse> cCourses = cCourseMapper.selectByExample(cCourseExample);
            scResult.setMessage("成功获取选课信息");
            scResult.setResult(1);
            for (int i = 0; i < cCourses.size(); i++) {
                CourseInfo courseInfo = new CourseInfo();
                BeanUtil.copyProperties(cCourses.get(i), courseInfo);
                courseInfo.setTname(uTeacherMapper.selectByPrimaryKey(courseInfo.getTid()).getTname());
                courseInfos.add(courseInfo);
            }
            scResult.setCourseInfo(courseInfos);
            return scResult;
        }
    }

    @Override
    public List<CourseInfo> getChooseCourceByID(Long id) {
        UStudentCourseExample uStudentCourseExample = new UStudentCourseExample();
        uStudentCourseExample.createCriteria().andStudentIdEqualTo(id);
        List<UStudentCourse> uStudentCourses = uStudentCourseMapper.selectByExample(uStudentCourseExample);
        List<CourseInfo> courseInfos = new ArrayList<>();
        for (int i = 0; i < uStudentCourses.size(); i++) {
            CCourse cCourse = cCourseMapper.selectByPrimaryKey(uStudentCourses.get(i).getCourseId());
            if (cCourse.getStates() == 1) {
                CourseInfo courseInfo = new CourseInfo();
                BeanUtil.copyProperties(cCourse, courseInfo);
                String tname = uTeacherMapper.selectByPrimaryKey(cCourse.getTid()).getTname();
                courseInfo.setTname(tname);
                courseInfos.add(courseInfo);
            }
        }
        return courseInfos;
    }

    @Override
    public int chooseCource(Long id, Long courseid) {
        CCourse cCourse = cCourseMapper.selectByPrimaryKey(courseid);
        UStudent uStudent = uStudentMapper.selectByPrimaryKey(id);
        UStudentCourseExample uStudentCourseExample = new UStudentCourseExample();
        uStudentCourseExample.createCriteria().andStudentIdEqualTo(id).andCourseIdEqualTo(courseid);
        List<UStudentCourse> uStudentCourses = uStudentCourseMapper.selectByExample(uStudentCourseExample);
        UStudentCourseExample uStudentCourseExample1 = new UStudentCourseExample();
        uStudentCourseExample1.createCriteria().andStudentIdEqualTo(id);
        List<UStudentCourse> uStudentCourses1 = uStudentCourseMapper.selectByExample(uStudentCourseExample1);
        if (cCourse.getChooseNumber() == cCourse.getLimitedElection()) {
            return -1;
        } else if (uStudentCourses.size() > 0) {
            return -2;
        }else if(uStudentCourses1.size() >= 2){
            return -3;
        }
        else {
            UStudentCourse uStudentCourse = new UStudentCourse();
            uStudentCourse.setStudentId(id);
            uStudentCourse.setCourseId(courseid);
            CCourse cCourse1 = new CCourse();
            cCourse1.setId(courseid);
            cCourse1.setChooseNumber(cCourse.getChooseNumber() + 1);
            cCourseMapper.updateByPrimaryKeySelective(cCourse1);
            return uStudentCourseMapper.insertSelective(uStudentCourse);
        }
    }

    @Override
    public int NochooseCourse(Long id, Long courseid) {
        CCourse cCourse = cCourseMapper.selectByPrimaryKey(courseid);
        UStudentCourseExample uStudentCourseExample = new UStudentCourseExample();
        uStudentCourseExample.createCriteria().andStudentIdEqualTo(id).andCourseIdEqualTo(courseid);
        CCourse cCourse1 = new CCourse();
        cCourse1.setId(courseid);
        cCourse1.setChooseNumber(cCourse.getChooseNumber() - 1);
        cCourseMapper.updateByPrimaryKeySelective(cCourse1);
        CCourseScoreExample cCourseScoreExample = new CCourseScoreExample();
        cCourseScoreExample.createCriteria().andCidEqualTo(courseid).andSidEqualTo(id);
        cCourseScoreMapper.deleteByExample(cCourseScoreExample);
        return uStudentCourseMapper.deleteByExample(uStudentCourseExample);
    }

    @Override
    public List<CourseInfo> getCourceByTID(Long tid) {
        CCourseExample cCourseExample = new CCourseExample();
        cCourseExample.createCriteria().andTidEqualTo(tid);
        List<CCourse> cCourses = cCourseMapper.selectByExample(cCourseExample);
        List<CourseInfo> courseInfos = new ArrayList<>();
        for (int i = 0; i < cCourses.size(); i++) {
            CourseInfo courseInfo = new CourseInfo();
            BeanUtil.copyProperties(cCourses.get(i), courseInfo);
            courseInfos.add(courseInfo);
        }
        return courseInfos;
    }

    @Override
    public List<StudentInfo> getChooseCourceByCID(Long cid, Long tid) {
        UStudentCourseExample uStudentCourseExample = new UStudentCourseExample();
        uStudentCourseExample.createCriteria().andCourseIdEqualTo(cid);
        List<UStudentCourse> uStudentCourses = uStudentCourseMapper.selectByExample(uStudentCourseExample);
        List<StudentInfo> uStudents = new ArrayList<>();
        for (int i = 0; i < uStudentCourses.size(); i++) {
            StudentInfo studentInfo = new StudentInfo();
            UStudent uStudent = uStudentMapper.selectByPrimaryKey(uStudentCourses.get(i).getStudentId());
            BeanUtil.copyProperties(uStudent, studentInfo);
            studentInfo.setDName(dDepartmentMapper.selectByPrimaryKey(uStudent.getDeptid()).getdName());
            CCourseScoreExample cCourseScoreExample = new CCourseScoreExample();
            cCourseScoreExample.createCriteria().andCidEqualTo(cid).andSidEqualTo(uStudent.getId()).andTidEqualTo(tid);
            List<CCourseScore> cCourseScores = cCourseScoreMapper.selectByExample(cCourseScoreExample);
            if (cCourseScores.size() == 0) {
                studentInfo.setScore("");
            } else {
                studentInfo.setScore(cCourseScores.get(0).getScore() + "");
            }
            uStudents.add(studentInfo);
        }
        return uStudents;
    }

    @Override
    public int ScoreToS(Long Tid, Long Sid, Long Cid, Integer score) {
        CCourseScoreExample cCourseScoreExample = new CCourseScoreExample();
        cCourseScoreExample.createCriteria().andCidEqualTo(Cid).andSidEqualTo(Sid).andTidEqualTo(Tid);
        List<CCourseScore> cCourseScores = cCourseScoreMapper.selectByExample(cCourseScoreExample);
        if (cCourseScores.size() > 0) {
            CCourseScore cCourseScore = new CCourseScore();
            cCourseScore.setId(cCourseScores.get(0).getId());
            cCourseScore.setScore(score);
            return cCourseScoreMapper.updateByPrimaryKeySelective(cCourseScore);
        } else {
            CCourseScore cCourseScore = new CCourseScore();
            cCourseScore.setCid(Cid);
            cCourseScore.setSid(Sid);
            cCourseScore.setTid(Tid);
            cCourseScore.setScore(score);
            return cCourseScoreMapper.insertSelective(cCourseScore);
        }
    }
}
