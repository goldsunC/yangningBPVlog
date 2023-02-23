package com.yangningBPVlog.boot.mapper;

import com.yangningBPVlog.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: 阳寜
 * @Date: 2022-03-28
 */
@Mapper
public interface userMapper {
    void registerUser(User user);
    User queryUserByEmail(@Param("email") String email);
}
