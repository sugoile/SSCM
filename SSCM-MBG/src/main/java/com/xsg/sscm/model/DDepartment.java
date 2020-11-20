package com.xsg.sscm.model;

import java.io.Serializable;

public class DDepartment implements Serializable {
    private Long id;

    private String dName;

    private Long affiliiatedInstitution;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public Long getAffiliiatedInstitution() {
        return affiliiatedInstitution;
    }

    public void setAffiliiatedInstitution(Long affiliiatedInstitution) {
        this.affiliiatedInstitution = affiliiatedInstitution;
    }
}