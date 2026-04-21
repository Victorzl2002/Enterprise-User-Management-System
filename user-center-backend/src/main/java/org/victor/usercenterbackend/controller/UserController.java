package org.victor.usercenterbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.victor.usercenterbackend.Exception.GlobalResponseException;
import org.victor.usercenterbackend.common.BaseResponse;
import org.victor.usercenterbackend.common.ErrorResponse;
import org.victor.usercenterbackend.common.ResponseUtils;
import org.victor.usercenterbackend.constants.UserConstant;
import org.victor.usercenterbackend.model.domain.User;
import org.victor.usercenterbackend.model.domain.request.UserLoginRequest;
import org.victor.usercenterbackend.model.domain.request.UserRegisterRequest;
import org.victor.usercenterbackend.service.UserService;


import java.util.List;

/**
 * @author: Victor_zl
 * @version: 1.0
 * @Description:
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping("/current")
    public BaseResponse<User> currentUserGet(HttpServletRequest request){
        User currentUser = userService.getCurrentUser(request);
        return ResponseUtils.success(currentUser);
    }

    @PostMapping("/register")
    public Long userRegister(@RequestBody UserRegisterRequest userRegisterRequest)
    {
        if (userRegisterRequest == null) {
            return -1L;
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            return -1L;
        }
        return userService.userRegister(userAccount, userPassword, checkPassword);
    }

    @PostMapping("/login")
    public BaseResponse<User> userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request ) {
        if (userLoginRequest == null) {
             throw new GlobalResponseException(ErrorResponse.NO_AUTH.getCode(),ErrorResponse.NO_AUTH.getMessage());
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            throw  new GlobalResponseException(ErrorResponse.NULL_ERROR.getCode(),ErrorResponse.NULL_ERROR.getMessage());
        }
        User loginUser = userService.login(userAccount, userPassword, request);
        if (loginUser == null) {
            throw new GlobalResponseException(ErrorResponse.NO_AUTH.getCode(),ErrorResponse.NO_AUTH.getMessage());
        }
        return ResponseUtils.success(loginUser);
    }

    @PostMapping("/logout")
    public BaseResponse<Boolean> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(UserConstant.USER_LOGIN_STATE);
        }
        return ResponseUtils.success(true);
    }

    @GetMapping("/search")
    public BaseResponse<List<User>> userSearchByUsername(@RequestParam String username, HttpServletRequest request) {
        if (!isAdmin(request)) {
            throw new GlobalResponseException(ErrorResponse.NO_AUTH.getCode(),ErrorResponse.NO_AUTH.getMessage());
        }
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)) {
            userQueryWrapper.like("username", username);
        }
        List<User> users = userService.list(userQueryWrapper).stream().map(userService::getSafeUser).toList();
        return ResponseUtils.success(users);
    }


    @DeleteMapping("/")
    public boolean delectById(@RequestParam Long id, HttpServletRequest request) {
          if (id == null || id <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id is invalid");
        }
        if (!isAdmin(request)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "login expired or unauthorized");
        }
        return userService.removeById(id);
    }


    private boolean isAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return false;
        }
        User user = (User) session.getAttribute(UserConstant.USER_LOGIN_STATE);
        return user != null && user.getUserRole() == UserConstant.ADMIN_ROLE;
    }
}