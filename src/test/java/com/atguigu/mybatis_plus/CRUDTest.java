package com.atguigu.mybatis_plus;

import com.atguigu.mybatis_plus.entity.User;
import com.atguigu.mybatis_plus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class CRUDTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testInsert(){
        User user=new User();
        user.setName("gxw");
        user.setEmail("111@qq.com");
        user.setAge(18);

        int result = userMapper.insert(user);
        System.out.println("影响行数"+result);
        System.out.println("user ID"+user.getId());
    }

    //批量查询
    @Test
    public void testSelectBatchIds(){
        List<User> Users = userMapper.selectBatchIds(Arrays.asList(1,2,3));
        Users.forEach(System.out::println);
    }
    @Test
    public void testSelectByMap(){
        HashMap<String,Object> map =  new HashMap<>();
        map.put("name","helen");
        map.put("age",18);
        List<User> users =userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectPage() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age");

        Page<User> page = new Page<>(1, 5);
        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, queryWrapper);
        //注意：此行必须使用 mapIPage 获取记录列表，否则会有数据类型转换错误
        mapIPage.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }
}
