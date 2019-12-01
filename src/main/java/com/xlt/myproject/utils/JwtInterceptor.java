package com.xlt.myproject.utils;

import com.xlt.myproject.controller.EmployeeController;
import io.jsonwebtoken.Claims;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = Logger.getLogger(JwtInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader("Authorization");
        //获取请求的路径
        String url=request.getRequestURI();
        //打印路径信息,作为后台日志进行查看
        logger.info("->>>>>Request URL="+url);
        //判断authHeader对象的内容是否不为空;
        //或者是否是访问的后台登录方法(login);
        if(url.endsWith("/login/auth")) {
            return true;
        }else if (authHeader == null || !authHeader.startsWith("token")){
            throw new LoginException("用户未登录，请登陆后重试");
        }
        //取得token
        String token = authHeader.substring(6);
        //验证token
        Claims claims = JwtUtils.validateToken(token).getClaims();
        request.setAttribute("username", claims.getSubject());
        logger.info("username:"+claims.getSubject());
        return true;
    }
}