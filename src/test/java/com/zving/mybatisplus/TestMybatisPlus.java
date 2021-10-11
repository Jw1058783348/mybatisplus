package com.zving.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zving.mybatisplus.entity.User;
import com.zving.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @AUTHOR Administrator
 * @TIME 2021/10/7 17:23
 * @VERSION 1.0
 */
@SpringBootTest
public class TestMybatisPlus {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20);
        Page<User> page = new Page<>(1,1);
        List<User> users = userMapper.selectList(queryWrapper);
        Page<User> userPage = userMapper.selectPage(page, queryWrapper);
        for (User user:users) {
            System.out.println(user);
        }
        System.out.println("----------------------");
        for (User user:userPage.getRecords()) {
            System.out.println(user);
        }
        User user = new User();
        user.setAge(27);
        user.setName("蒋伟");
        user.setEmail("1@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("影响的行数:"+insert+",用户ID:"+user.getId());
    }
}
