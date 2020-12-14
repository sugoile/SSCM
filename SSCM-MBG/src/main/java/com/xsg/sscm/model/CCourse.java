package com.xsg.sscm.model;

import java.io.Serializable;

public class CCourse implements Serializable {
    private Long id;

    private String name;

    private Integer credit;

    private Integer classHours;

    private String planType;

    private String teachingClass;

    private Long tid;

    private Integer limitedElection;

    private Integer classNumber;

    private Integer chooseNumber;

    private Integer states;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getClassHours() {
        return classHours;
    }

    public void setClassHours(Integer classHours) {
        this.classHours = classHours;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getTeachingClass() {
        return teachingClass;
    }

    public void setTeachingClass(String teachingClass) {
        this.teachingClass = teachingClass;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Integer getLimitedElection() {
        return limitedElection;
    }

    public void setLimitedElection(Integer limitedElection) {
        this.limitedElection = limitedElection;
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public Integer getChooseNumber() {
        return chooseNumber;
    }

    public void setChooseNumber(Integer chooseNumber) {
        this.chooseNumber = chooseNumber;
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }
}