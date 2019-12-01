package com.xlt.myproject.controller;

import com.xlt.myproject.model.User;
import com.xlt.myproject.model.UserResponse;
import com.xlt.myproject.service.impl.UserServiceImpl;
import com.xlt.myproject.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController(value="userController")
@RequestMapping("/user")
public class UserController {
    private static org.apache.log4j.Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/info", method = RequestMethod.GET, produces="application/json")
    public UserResponse userInfo(User user, HttpServletRequest request) {
        logger.info("UserController.userInfo"+user.toString());
        UserResponse response=new UserResponse();
        String token=  request.getHeader("token");
        try {
            Claims claims=JwtUtils.parseJWT(token);
            logger.info("claims="+claims);
        } catch (Exception e) {
            logger.error("JwtUtils.parseJWT encounter error:"+e.toString());
            e.printStackTrace();
        }
        return response;
    }
}
