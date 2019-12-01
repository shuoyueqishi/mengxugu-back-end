package com.xlt.myproject.mapper;

import com.xlt.myproject.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.portable.ApplicationException;

import java.util.List;

@Mapper
public interface ImemberDao {
    List<Member> findMemberPageList(@Param("member") Member member)throws ApplicationException;
}
