package com.tom.srccode.deep.analysis.chapter8.springjdbc;

import java.util.List;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月28日 20:33:00
 */
public interface IUserServce {

    void save(UserPO userPO);
    List<UserPO> getUsers();
}
