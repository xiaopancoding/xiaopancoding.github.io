package com.P.mapper;

import com.P.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {


    void insertUser(@Param("emps") List<User> emps);


    List<User> getUsers(@Param("empId") Integer empId, @Param("age") Integer age);


}
