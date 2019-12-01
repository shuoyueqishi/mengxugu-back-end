package com.xlt.myproject.controller;

import com.xlt.myproject.constant.Constant;
import com.xlt.myproject.constant.JwtConstant;
import com.xlt.myproject.model.User;
import com.xlt.myproject.model.UserResponse;
import com.xlt.myproject.service.impl.UserServiceImpl;
import com.xlt.myproject.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController(value="loginController")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/auth", method = RequestMethod.GET, produces="application/json")
    public UserResponse login(@RequestParam("username")String username, @RequestParam("password")String password) {
        UserResponse userResponse = new UserResponse();
        User loginUser = new User();
        loginUser.setNumber(username);
        // loginUser.setPassword(SHAUtils.encodeData(password));
        loginUser.setPassword(password);
        UserResponse response =  userService.findUserByCondition(loginUser);
        Long userId=0L;
        if (response.getStatus().equals(Constant.Status.SUCCESS)
                && !CollectionUtils.isEmpty(response.getResult())) {
            userId=response.getResult().get(0).getId();
            //把token返回给客户端-->客户端保存至cookie-->客户端每次请求附带cookie参数
            String token = JwtUtils.createJWT(String.valueOf(userId), username, JwtConstant.JWT_TTL);
            User authUser = new User();
            authUser.setName(username);
            authUser.setId(userId);
            authUser.setToken(token);
            List<User> list = new ArrayList<>();
            list.add(authUser);
            userResponse.setStatus(Constant.Status.SUCCESS);
            userResponse.setResult(list);
            userResponse.setMessage(username+" login successfully");
        } else {
            userResponse.setStatus(Constant.Status.FAIL);
            userResponse.setMessage(username+" password is not correct.");
        }
        return userResponse;
    }

}