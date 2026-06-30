package com.tom.srccode.deep.analysis.chapter9;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * @author tom
 * @version 1.0.0
 * @Description TODO
 * @createTime 2026年07月01日 06:32:00
 */
@Slf4j
public class Chapter9UnitTest {

    static SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();

    @Test
    public void testAdd() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserPO userPO = new UserPO("3", "张三03", 33, "男");
            mapper.insertUser(userPO);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGet() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserPO userPO = mapper.getUser("3");
            log.info("userPO = {}", userPO);
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }


}
