package com.atguigu.mybatis_plus.mapper;

import com.atguigu.mybatis_plus.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelectUser(){
        List<User> Users = userMapper.selectList(null);
        Users.forEach(System.out::println);
    }

}