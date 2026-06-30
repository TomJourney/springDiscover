package com.tom.srccode.deep.analysis.chapter9;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年07月01日 06:17:00
 */
public interface UserMapper {
    void insertUser(UserPO user);
    UserPO getUser(String id);
}
