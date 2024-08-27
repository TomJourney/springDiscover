package com.tom.springnote.chpater14.model;

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

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
