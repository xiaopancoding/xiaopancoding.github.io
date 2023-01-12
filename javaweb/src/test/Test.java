package test;

import user.CaoZuo;
import user.userBean;
import user.userDao;

public class Test {


    public static void main(String[] args) {

        CaoZuo caoZuo = new userDao();   // 这里是一个多态， 最大的就接口了， 然后通过创建一个子类， 调用子类的方法
//        System.out.println(caoZuo.selectUsername("pan"));

        System.out.println(caoZuo.saveUser(new userBean("pan222", "pan222@qq.com", "12345")));
    }
}
