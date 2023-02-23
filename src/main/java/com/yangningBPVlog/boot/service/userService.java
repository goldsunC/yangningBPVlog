package com.yangningBPVlog.boot.service;

import com.yangningBPVlog.boot.entity.User;
import com.yangningBPVlog.boot.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: 阳寜
 * @Date: 2022-03-28
 */

@Service
public class userService {

    @Autowired
    userMapper userMapper;

    public User login(String email) {
        User user = userMapper.queryUserByEmail(email);
        return user;
    }

    //注册用户
    public String registerUser(User user) {
        try {
            if (user.getUserName() != null &&
                user.getPassWord() != null &&
                user.getEmail() != null &&
                user.getNickName() != null &&
                user.getAvatar() != null)
            {
                user.setType(0);
                user.setCreatTime(new Date());
                user.setUpdateTime(new Date());
                userMapper.registerUser(user);
                return "注册成功";
            }
            return "您输入的信息有问题，请重新注册";
        }catch (Exception e) {
            e.printStackTrace();
            return "您输入的信息有问题，请重新注册";
        }
    }

}
