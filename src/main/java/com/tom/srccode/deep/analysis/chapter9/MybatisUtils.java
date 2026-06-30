package com.tom.srccode.deep.analysis.chapter9;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年07月01日 06:29:00
 */
@Slf4j
public class MybatisUtils {

    @Getter
    private final static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "a_src_deep_analysis/chapter9/mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (Exception e) {
            log.error("读取 mybatis-config.xml文件异常", e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }
}
