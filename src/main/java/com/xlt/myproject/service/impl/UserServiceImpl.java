package com.xlt.myproject.service.impl;

import com.xlt.myproject.constant.Constant;
import com.xlt.myproject.mapper.IuserDao;
import com.xlt.myproject.model.User;
import com.xlt.myproject.model.UserResponse;
import com.xlt.myproject.service.api.IuserService;
import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
@MapperScan("com.xlt.myproject.mapper")
public class UserServiceImpl implements IuserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private IuserDao userDao;

    @Override
    public UserResponse findUserByCondition(User user) {
        logger.info("findUserByCondition input info: " + user);
        UserResponse response = new UserResponse();
        try {
            List<User> users = userDao.findUserByCondition(user);
            response.setResult(users);
            response.setStatus(Constant.Status.SUCCESS);
            response.setMessage("findUserByCondition successfully, " + users.size() + " found");
        } catch (ApplicationException e) {
            response.setStatus(Constant.Status.SUCCESS);
            response.setMessage("findUserByCondition failed" + e.toString());
            logger.error("findUserByCondition failed:" + e);
        }
        return response;
    }

    @Override
    public UserResponse updateUserPassword(User user) {
         logger.info("UserServiceImpl.updateUserPassword input info:"+user);
         UserResponse response = new UserResponse();
         try {
             int rows = userDao.updateUserPassword(user);
             response.setMessage("update user number["+user.getNumber()+"] successfully.");
             response.setStatus(Constant.Status.SUCCESS);
         } catch (ApplicationException e) {
             response.setStatus(Constant.Status.FAIL);
             response.setMessage("update user password failed.");
             logger.error("update user password failed."+e);
         }
         return  response;
    }
}
