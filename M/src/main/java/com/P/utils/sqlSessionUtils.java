package com.P.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.ResourceBundle;

public class sqlSessionUtils {

    public static SqlSession sqlSession() {

        SqlSession sqlSession = null;

        try {

            //  获取核心配置文件的输入流
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 获取SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

            // 获取SqlSessionFactory
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);

            // 获取sqlSession就ok
            sqlSession = build.openSession(true);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
        


}
