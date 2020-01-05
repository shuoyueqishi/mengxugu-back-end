package com.xlt.myproject.controller;

import com.xlt.myproject.constant.Constant;
import com.xlt.myproject.model.User;
import com.xlt.myproject.model.UserResponse;
import com.xlt.myproject.service.impl.UserServiceImpl;
import com.xlt.myproject.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController(value="userController")
@RequestMapping("/user")
public class UserController {
    private static org.apache.log4j.Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/check", method = RequestMethod.GET, produces="application/json")
    public UserResponse checkUser(User user) {
        logger.info("UserController.userInfo"+user.toString());
        UserResponse response=new UserResponse();
        response = userService.findUserByCondition(user);
        if (Constant.Status.SUCCESS.equals(response.getStatus())) {
            List<User> list = response.getResult();
            if (list.size() == 1) {
                response.setStatus(Constant.Status.SUCCESS);
                response.setMessage("Old password is correct. Try next step.");
            } else {
                response.setStatus(Constant.Status.FAIL);
                response.setMessage("User number or password is not correct.");
            }
        }
        return response;
    }
    @RequestMapping(value = "/update/password", method = RequestMethod.PUT, produces="application/json")
    public UserResponse updateUserPassword(@RequestBody()User user) {
        logger.info("UserController.updateUser"+user.toString());
        UserResponse response=new UserResponse();
        response = userService.updateUserPassword(user);
        return response;
    }
}
