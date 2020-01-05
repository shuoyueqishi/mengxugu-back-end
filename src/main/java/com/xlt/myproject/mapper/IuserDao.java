package com.xlt.myproject.mapper;

import com.xlt.myproject.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value="IuserDao")
public interface IuserDao {
    List<User> findUserByCondition(@Param("user") User user) throws ApplicationException;
    int updateUserPassword(@Param("user") User user) throws ApplicationException;
}
