package com.tom.springnote.chpater14.model;

import java.io.Serializable;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName UserDto.java
 * @Description TODO
 * @createTime 2024年08月27日 21:36:00
 */
public class UserDto {
    private int id;

    private String name;

    private String mobilePhone;

    private String addr;

    private String remark;

    public UserDto() {
        // do nothing.
    }

    public UserDto(int id, String name, String mobilePhone, String addr) {
        this.id = id;
        this.name = name;
        this.mobilePhone = mobilePhone;
        this.addr = addr;
    }

    public UserDto(String name, String mobilePhone, String addr, String remark) {
        this.name = name;
        this.mobilePhone = mobilePhone;
        this.addr = addr;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", addr='" + addr + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
