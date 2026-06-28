package com.tom.srccode.deep.analysis.chapter8.springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年06月28日 20:33:00
 */
public class UserServiceImpl implements IUserServce {

    private JdbcTemplate jdbcTemplate;


    public UserServiceImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(UserPO userPO) {
        String userId = String.valueOf(System.currentTimeMillis());
        jdbcTemplate.update("insert into spring_user_tbl(id, name, age, sex) values(?,?,?,?)",
                new Object[]{userId, userPO.getName(), userPO.getAge(), userPO.getSex()}
                , new int[]{Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR});
    }

    @Override
    public List<UserPO> getUsers() {
        List<UserPO> list = jdbcTemplate.query("select * from spring_user_tbl", new UserRowMapper());
        return list;
    }
}
