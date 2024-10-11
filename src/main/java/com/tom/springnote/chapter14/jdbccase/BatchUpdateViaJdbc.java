package com.tom.springnote.chapter14.jdbccase;

import com.tom.springnote.chapter14.model.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName BatchUpdateViaJdbc.java
 * @Description TODO
 * @createTime 2024年08月28日 20:34:00
 */
public class BatchUpdateViaJdbc {

    public int[] batchInsert(List<UserDto> userDtoList) {
        String sql = "insert into user_tbl(name, mobile_phone, addr, remark) values(?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            connection.setAutoCommit(false); // 设置手动提交
            preparedStatement = connection.prepareStatement(sql);
            // 批量设置占位符参数
            for (UserDto userDto : userDtoList) {
                preparedStatement.setString(1, userDto.getName());
                preparedStatement.setString(2, userDto.getMobilePhone());
                preparedStatement.setString(3, userDto.getAddr());
                preparedStatement.setString(4, userDto.getRemark());
                preparedStatement.addBatch();
            }
            // 执行批量更新
            int[] resultArr = preparedStatement.executeBatch();
            connection.commit();
            return resultArr;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    System.out.println("关闭statement成功");
                } catch (SQLException e) {
                    System.out.println("关闭statement异常");
                    e.printStackTrace(System.err);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("关闭connection成功");
                } catch (SQLException e) {
                    System.out.println("关闭connection异常");
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}
