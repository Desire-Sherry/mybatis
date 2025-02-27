package com.sherry.util;

import com.sherry.javabean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MyBatisTest {

    public static void main(String[] args) {
        //1、创建SqlSessionFactory对象，也是单例模式的
        SqlSessionFactory factory = MyBatisUtil.getSqlSessionFactory();
        //2、创建SqlSession对象 true 自动提交事务 不写也没事 因为默认在sqlsession关闭时提交事务
        SqlSession session = factory.openSession(true);
        //3、调用session的方法namespace的名字.id
        List<User> users = session.selectList("user.selectAllUser");
        //4、打印测试
        for(User u:users){
            System.out.println(u);
        }
        //5、关闭资源
        session.close();
    }
}