package com.bootproject.sklweb.entity;

import java.util.Date;

public class User {
    /** 用户主键*/
    private String userid;

    /** 登陆密码*/
    private String password;

    /** 安全码*/
    private String acctoken;

    /** 0-超级管理 1-普通用户*/
    private String type;

    /** 0-正常 1-冻结*/
    private String state;

    /** 用户创建时间*/
    private Date createtime;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAcctoken() {
        return acctoken;
    }

    public void setAcctoken(String acctoken) {
        this.acctoken = acctoken == null ? null : acctoken.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}