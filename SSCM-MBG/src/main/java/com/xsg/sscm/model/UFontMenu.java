package com.xsg.sscm.model;

import java.io.Serializable;

public class UFontMenu implements Serializable {
    private Long id;

    private String fontMenuName;

    private Long pid;

    private String path;

    private Integer sort;

    private String fontIcon;

    private String description;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFontMenuName() {
        return fontMenuName;
    }

    public void setFontMenuName(String fontMenuName) {
        this.fontMenuName = fontMenuName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getFontIcon() {
        return fontIcon;
    }

    public void setFontIcon(String fontIcon) {
        this.fontIcon = fontIcon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}