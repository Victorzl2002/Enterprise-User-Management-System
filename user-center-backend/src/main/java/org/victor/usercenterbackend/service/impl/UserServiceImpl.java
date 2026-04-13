package org.victor.usercenterbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;
import org.victor.usercenterbackend.constants.UserConstant;
import org.victor.usercenterbackend.model.domain.User;
import org.victor.usercenterbackend.service.UserService;
import org.victor.usercenterbackend.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import static org.victor.usercenterbackend.constants.UserConstant.USER_LOGIN_STATE;

/**
* @author victorzl
* @description 针对表【user】的数据库操作Service实现
* @createDate 2026-03-26 22:07:07
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    /**
     * 加密盐值
     */
    private static final String SALT = "ucb";

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {

        //1.校验
        //非空
        if(userAccount ==null || userPassword == null || checkPassword == null){return -1;}

        //校验账户密码是否合规
        if(userAccount.length()<4 || userPassword.length()<8){return -1;}
        String validPattern = "\\pP|\\pS|\\s+";
        if (Pattern.compile(validPattern).matcher(userAccount).find()){return -1;}

        //校验密码与确认密码是否一致
        if(!userPassword.equals(checkPassword)){return -1;}

        //校验账户是否重复
        Wrapper<User> userAccountWrapper = new QueryWrapper<User>().eq("userAccount",userAccount);
        long count = this.count(userAccountWrapper);
        if(count > 0){return -1;}

        //2.加密
        String digestPassword = DigestUtils.md5DigestAsHex((SALT+userPassword).getBytes());

        //写入数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(digestPassword);
        this.save(user);
        return user.getId();
    }

    @Override
    public User login(String userAccount, String userPassword, HttpServletRequest request) {
        //非空
        if(userAccount ==null || userPassword == null){return null;}

        //校验账户密码是否合规
        if(userAccount.length()<4 || userPassword.length()<8){return null;}
        String validPattern = "\\pP|\\pS|\\s+";
        if (Pattern.compile(validPattern).matcher(userAccount).find()){return null;}


        //2.加密
        String digestPassword = DigestUtils.md5DigestAsHex((SALT+userPassword).getBytes());

        //校验用户是否存在
        Wrapper<User> userAccountWrapper = new QueryWrapper<User>()
                .eq("userAccount",userAccount)
                .eq("userPassword",digestPassword);

        User user = this.getOne(userAccountWrapper);
        //用户不存在
        if(user == null){
            log.info("user login fail,userInfo cannot match in database");
            return null;
        }

        //3.用户脱敏
        User cleanUser = getSafeUser(user);

        //4.记录用户的登录态
        request.getSession().setAttribute(USER_LOGIN_STATE,cleanUser);
        return cleanUser;
    }

    @Override
    public User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "not login");
        }

        User loginUser = (User) session.getAttribute(UserConstant.USER_LOGIN_STATE);
        if (loginUser == null) {
            session.invalidate();
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "not login");
        }

         //从数据库查询（追求数据一致性，避免用户信息被修改后无法获取最新的用户信息）
        User dbUser = this.getById(loginUser.getId());
        if (dbUser == null) {
            session.invalidate();
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "user not found");
        }
        return getSafeUser(dbUser);
    }


    @Override
    public User getSafeUser(User user) {
        User cleanUser = new User();
        cleanUser.setId(user.getId());
        cleanUser.setUserAccount(user.getUserAccount());
        cleanUser.setUsername(user.getUsername());
        cleanUser.setUserPassword(null);
        cleanUser.setAvatar(user.getAvatar());
        cleanUser.setGender(user.getGender());
        cleanUser.setEmail(user.getEmail());
        cleanUser.setUserRole(user.getUserRole());
        cleanUser.setUserStatus(user.getUserStatus());
        cleanUser.setCreateTime(user.getCreateTime());
        return cleanUser;
    }


}




