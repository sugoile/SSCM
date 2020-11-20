package com.xsg.sscm.model;

import java.io.Serializable;

public class DStaff implements Serializable {
    private Long id;

    private String name;

    private Long affiliiatedPosition;

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

    public Long getAffiliiatedPosition() {
        return affiliiatedPosition;
    }

    public void setAffiliiatedPosition(Long affiliiatedPosition) {
        this.affiliiatedPosition = affiliiatedPosition;
    }
}