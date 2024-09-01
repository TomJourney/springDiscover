package com.tom.springnote.chpater14.operationobject.update;

import com.tom.springnote.chpater14.model.UserDto;
import com.tom.springnote.utils.DataSourceUtils;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

import java.sql.Types;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName SqlUpdateMain.java
 * @Description TODO
 * @createTime 2024年08月28日 19:50:00
 */
public class BatchSqlUpdateMain {
    public static void main(String[] args) {
        String sql = "update user_tbl set name = ? where id = ?";
        BatchSqlUpdate batchSqlUpdate = new BatchSqlUpdate(DataSourceUtils.getDataSource(), sql);
        batchSqlUpdate.declareParameter(new SqlParameter(Types.VARCHAR));
        batchSqlUpdate.declareParameter(new SqlParameter(Types.BIGINT));
        batchSqlUpdate.compile(); // 调用compile()方法，检查与设置操作对象sqlUpdate所必须的各种参数

        // 执行sql
        List<UserDto> userDtoList = Arrays.asList(
                new UserDto(500003, "李四01")
                , new UserDto(500004, "李四02")
                , new UserDto(500005, "李四03"));
        for (UserDto userDto : userDtoList) {
            batchSqlUpdate.update(new Object[]{userDto.getName(), userDto.getId()});
        }
        // BatchSqlUpdate.update()方法： 把数据添加到批量更新的缓存队列中； 当队列中的数据量等于batchSize时，会自动触发批量更新操作；
        // 否则， 数据只是被添加到了缓存队列而已，并没有真正提交更新sql；
        // 调用flush方法会强行刷新缓存队列中的更新操作
        // batchSize可以调整
        batchSqlUpdate.setBatchSize(500);
        batchSqlUpdate.flush();
    }
}
