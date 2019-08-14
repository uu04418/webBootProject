package com.bootproject.sklweb.entity;

import java.util.Date;

public class User {
    /** 用户主键*/
    private Long userId;

    /** 登陆账号*/
    private String userName;

    /** 登陆密码*/
    private String passWord;

    /** 安全码*/
    private String acctoken;

    /** 用户类型 0-表示普通用户 1-管理员用户*/
    private Integer type;

    /** 用户状态 0-冻结 1-正常*/
    private Integer state;

    /** 用户创建时间*/
    private Date createTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getAcctoken() {
        return acctoken;
    }

    public void setAcctoken(String acctoken) {
        this.acctoken = acctoken == null ? null : acctoken.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}