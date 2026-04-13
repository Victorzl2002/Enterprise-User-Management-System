package org.victor.usercenterbackend.service;

import jakarta.servlet.http.HttpServletRequest;
import org.victor.usercenterbackend.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author victorzl
 * @description 针对表【user】的数据库操作Service
 * @createDate 2026-03-26 22:07:07
 */
public interface UserService extends IService<User> {

    /**
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 确认密码
     * @return 新用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param request       请求对象
     * @return              用户信息
     */
    User login(String userAccount, String userPassword,HttpServletRequest request);

    /**
     *
     * @param               user
     * @return              脱敏用户信息
     */
    User getSafeUser(User user);

    /**
     *
     * @param request    请求对象
     * @return User      当前登录态用户信息
     */
    User getCurrentUser(HttpServletRequest request);
}
