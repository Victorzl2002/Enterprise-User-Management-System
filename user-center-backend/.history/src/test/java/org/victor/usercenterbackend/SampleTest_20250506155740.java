package org.victor.usercenterbackend;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.victor.usercenterbackend.entity.User;

import java.util.List;

@SpringBootTest
public class SampleTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        System.out.println("查询到的用户数量: " + userList.size());
        Assert.isTrue(5 == userList.size(), "用户数量不正确");
        
        System.out.println("用户列表详情：");
        for (User user : userList) {
            System.out.println("用户ID: " + user.getId());
            System.out.println("用户名: " + user.getName());
            System.out.println("年龄: " + user.getAge());
            System.out.println("邮箱: " + user.getEmail());
            System.out.println("-------------------");
        }
    }

}