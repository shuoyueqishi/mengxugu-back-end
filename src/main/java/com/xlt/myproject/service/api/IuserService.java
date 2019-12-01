package com.xlt.myproject.service.api;

import com.xlt.myproject.model.User;
import com.xlt.myproject.model.UserResponse;

public interface IuserService {
    UserResponse findUserByCondition(User user);
}
