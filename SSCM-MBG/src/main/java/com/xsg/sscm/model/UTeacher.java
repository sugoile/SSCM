package com.xsg.sscm.model;

import java.io.Serializable;
import java.util.Date;

public class UTeacher implements Serializable {
    private Long id;

    private Long tno;

    private String tname;

    private Integer sex;

    private String education;

    private String position;

    private String maincourse;

    private String secondcourse;

    private Long deptid;

    private String campus;

    private String password;

    private Date createTime;

    private Date loginTime;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTno() {
        return tno;
    }

    public void setTno(Long tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMaincourse() {
        return maincourse;
    }

    public void setMaincourse(String maincourse) {
        this.maincourse = maincourse;
    }

    public String getSecondcourse() {
        return secondcourse;
    }

    public void setSecondcourse(String secondcourse) {
        this.secondcourse = secondcourse;
    }

    public Long getDeptid() {
        return deptid;
    }

    public void setDeptid(Long deptid) {
        this.deptid = deptid;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}