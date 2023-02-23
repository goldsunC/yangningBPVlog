package com.yangningBPVlog.boot.controller.admin;

import com.yangningBPVlog.boot.entity.User;
import com.yangningBPVlog.boot.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.net.URI;

/**
 * @author: 阳寜
 * @Date: 2022-03-28
 */

/*
 * 这个Controller负责用户后台登录控制
 * */
@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminIndexController {
    @Autowired
    userService userService;
    //切换后台
    @GetMapping
    public String admin() {
        return "admin/index";
    }
    //登录页面
    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }
    //登录提交
    @PostMapping("/login")
    public String loginPost(
            @RequestParam("email") String email,
            @RequestParam("passWord") String passWord,
            HttpSession session,
            Model model,
            @RequestParam(value = "URI",required = false) String URI)
    {
        User user = userService.login(email);
        //没有这个后台管理员,邮箱没注册重新登录
        if (user == null) {
            model.addAttribute("msg","无此管理员，请重新登录！");
            return "admin/login";
        }
        log.info("查询出来的超级管理员用户为:"+user);
        log.info("URI:"+URI);
        //有此管理员，且密码正确，进入后台页面
        if (user.getPassWord().equals(passWord)) {
            session.setAttribute("user",user);
            model.addAttribute("URI",URI);//这一行仅仅是让login.html不漂红
            if (!URI.equals("")) {
                return "redirect:"+URI;
            }else {
                return "redirect:/admin";
            }
        }
        //  有此管理员但密码不对，重新登录
        else {
            model.addAttribute("msg","密码错误");
            return "admin/login";
        }
    }
    @GetMapping("/logout")
    public String logOut(HttpSession session, SessionStatus sessionStatus) {
        session.invalidate();//让session失效
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
