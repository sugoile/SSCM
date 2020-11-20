package com.xsg.sscm.model;

import java.io.Serializable;

public class UTeacher implements Serializable {
    private Long id;

    private Long tno;

    private String name;

    private Integer sex;

    private Integer age;

    private String education;

    private String position;

    private String maincourse;

    private String secondcourse;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
}