package org.victor.usercenterbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.victor.usercenterbackend.model.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author victorzl
* @description 针对表【user】的数据库操作Mapper
* @createDate 2026-03-26 22:07:07
* @Entity org.victor.usercenterbackend.model.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




