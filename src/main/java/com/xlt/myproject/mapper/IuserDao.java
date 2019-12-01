package com.xlt.myproject.mapper;

import com.xlt.myproject.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.portable.ApplicationException;

import java.util.List;

@Mapper
public interface IuserDao {
    public List<User> findUserByCondition(@Param("user")User user) throws ApplicationException;
}
