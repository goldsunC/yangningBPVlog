package com.yangningBPVlog.boot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: 阳寜
 * @Date: 2022-03-28
 */

@Slf4j
public class loginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        //从Session拿到“user”属性
        Object user = session.getAttribute("user");
        //如果登录的有用户
        if (user != null) {
            //放行
            return true;
        }
        //否则即未登录用户,给它重定向到login页面
        request.setAttribute("msg","请先登录");
        String requestURI = request.getRequestURI();
        request.setAttribute("URI",requestURI);
        log.info("当前拦截的路径为："+requestURI);
        //转发到登录页面
        request.getRequestDispatcher("/admin/login").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
