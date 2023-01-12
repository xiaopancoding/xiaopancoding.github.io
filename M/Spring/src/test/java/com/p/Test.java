package com.p;


import cpm.p.pojo.User;
import cpm.p.pojo.helloSpring;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cpm.p.pojo.*;

public class Test {


    @org.junit.Test
    public void G() {

        /**
         * 获取bean的三种方式
         *      1. 根据bean的id
         *      2. 根据bean的类型
         *          根据bean的类型获取时，可能会出现两种异常
         *              若没有任何一个类型匹配的bean（其实就是bean里面没有这个类）， 就会报  NoSuchBeanDefinitionException
         *              若有多个类型匹配的bean(其实就是在bean里面有多个相同类型的bean， 只是id不同而已)，  就会报：  NoUniqueBeanDefinitionException
         *      3. 根据bean的id 和 类型来获取
         *
         */

        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");

        student bean = ioc.getBean(student.class);
        System.out.println(bean);


    }

}
