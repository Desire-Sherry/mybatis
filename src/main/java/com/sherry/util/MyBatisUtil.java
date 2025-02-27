package com.sherry.util;

import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//7、将SqlSessionFactory设计成单例模式，做一个工具类
//因为mybatis启动时会加载配置文件进行初始化
public  class MyBatisUtil {
    private MyBatisUtil(){}
    private static SqlSessionFactory sqlSessionFactory;
    static{
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}