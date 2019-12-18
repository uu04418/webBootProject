package com.bootproject.sklweb.entity;

/**
 * @Description 产品适用场合
 * @author  uu04418
 * @date  2019年12月18日  上午10:14:43
 */
public class Scene {
    /** */
    private Integer id;

    /** 适用场合*/
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}