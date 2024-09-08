package com.tom.springnote.common.model;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName UserDto.java
 * @Description TODO
 * @createTime 2024年09月08日 14:39:00
 */
public class UserDto {
    private Long id;

    private String name;

    private String mobilePhone;

    private String addr;

    private String remark;

    public static UserDto newUserDto(Long id) {
        UserDto userDto = new UserDto();
        userDto.id = id;
        userDto.name = "用户名" + id;
        userDto.mobilePhone = "手机" + id;
        userDto.addr = "成都高新区" + id + "号";
        userDto.remark = "备注" + id;
        return userDto;
    }

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
