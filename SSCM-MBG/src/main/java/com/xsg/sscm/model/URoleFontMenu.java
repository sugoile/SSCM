package com.xsg.sscm.model;

import java.io.Serializable;

public class URoleFontMenu implements Serializable {
    private Long id;

    private Long roleId;

    private Long fontMenuId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getFontMenuId() {
        return fontMenuId;
    }

    public void setFontMenuId(Long fontMenuId) {
        this.fontMenuId = fontMenuId;
    }
}