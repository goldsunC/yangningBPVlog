package com.yangningBPVlog.boot.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 阳寜
 * @Date: 2022-03-28
 */
@Slf4j
@Aspect
@Component
public class logAspect {

    //execution中的内容用来规定此切面拦截哪些类
    @Pointcut("execution(* com.yangningBPVlog.boot.controller.*.*(..))")
    public void log() {}

    //在切面之前执行方法
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url,ip,classMethod,args);

        log.info("Request : {}",requestLog);
    }
    //在切面之后执行方法
    @After("log()")
    public void doAfter() {
        //log.info("---------------doAfter--------------");
    }

//    返回的结果
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result) {
        log.info("Result : {}" + result);
    }



    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private class RequestLog {
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;
    }
}
