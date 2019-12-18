package com.bootproject.sklweb.entity;

import java.util.Date;

/**
 * @Description 意见反馈
 * @author  uu04418
 * @date  2019年12月18日  上午10:15:01
 */
public class Sugges {
    /** 意见反馈主键*/
    private Long id;

    /** 联系人*/
    private String name;

    /** 联系电话*/
    private String telephone;

    /** 发布内容*/
    private String content;

    /** */
    private Date createtime;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}