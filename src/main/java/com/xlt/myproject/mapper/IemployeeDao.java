package com.xlt.myproject.mapper;

import com.xlt.myproject.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value="IemployeeDao")
public interface IemployeeDao {

    public List<Employee> findEmployeeAll() throws ApplicationException;

    public List<Employee> findEmployeeByCondition(Employee employee) throws ApplicationException;
}
