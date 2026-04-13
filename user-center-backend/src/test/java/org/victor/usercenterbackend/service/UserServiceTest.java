package org.victor.usercenterbackend.service;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.victor.usercenterbackend.model.domain.User;

/**
 * @author: Victor_zl
 * @version: 1.0
 * @Description:
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public void testAddUser() {
        User user = new User();
        user.setUserAccount("test_zl");
        user.setUsername("123");
        user.setUserPassword("xxx");
        user.setAvatar("https://www.codefather.cn/_next/image?url=%2Fimages%2Flogo.png&w=256&q=75");
        user.setGender(0);
        user.setEmail("xxx");
        user.setUserStatus(0);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setIsDelect(0);
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    public void registerUser() {
        long result = userService.userRegister("victorzl", "12345678", "12345678");
        Assertions.assertEquals(-1,result);
    }
}