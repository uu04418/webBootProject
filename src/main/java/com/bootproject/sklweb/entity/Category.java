package com.bootproject.sklweb.entity;


/**
 * @Description 产品类别 fatherid : 0 表示 首级分类
 * @author  uu04418
 * @date  2019年12月18日  上午10:13:04
 */
public class Category {
    /** 产品类别id*/
    private Long id;

    /** 产品类别名称*/
    private String name;

    /** 产品类别图片*/
    private String pictures;

    /** 产品类别上级id*/
    private Long fatherid;

    /** 类别描述*/
    private String content;

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
        this.name = name == null ? null : name.trim();
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures == null ? null : pictures.trim();
    }

    public Long getFatherid() {
        return fatherid;
    }

    public void setFatherid(Long fatherid) {
        this.fatherid = fatherid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}