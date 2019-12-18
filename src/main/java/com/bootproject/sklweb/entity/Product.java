package com.bootproject.sklweb.entity;

import java.util.Date;

public class Product {
    /** 产品主键*/
    private Long id;

    /** 发布人id*/
    private String userid;

    /** 产品类别id*/
    private Long categoryid;

    /** 产品名称*/
    private String name;

    /** 产品高度*/
    private Double height;

    /** 产品宽度*/
    private Double width;

    /** 产品图片*/
    private String pictures;

    /** 产品描述*/
    private String content;

    /** 适用场景*/
    private String sceneid;

    /** 0-下架 1-上架 */
    private Integer state;

    /** 发布时间*/
    private Date createtime;

    /** 更新时间*/
    private Date updatetime;

    /** 0-置顶 1-不置顶*/
    private Integer istop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures == null ? null : pictures.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSceneid() {
        return sceneid;
    }

    public void setSceneid(String sceneid) {
        this.sceneid = sceneid == null ? null : sceneid.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getIstop() {
        return istop;
    }

    public void setIstop(Integer istop) {
        this.istop = istop;
    }
}