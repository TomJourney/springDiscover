package com.tom.srccode.deep.analysis.chapter8.springjdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月28日 20:30:00
 */
@Data
@NoArgsConstructor
public class UserPO {
    private String id;
    private String name;
    private int age;
    private String sex;

    public UserPO(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public UserPO(String id, String name, int age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
