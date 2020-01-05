package com.xlt.myproject.service.impl;

import com.xlt.myproject.constant.Constant;
import com.xlt.myproject.mapper.IemployeeDao;
import com.xlt.myproject.model.Employee;
import com.xlt.myproject.model.EmployeeResponse;
import com.xlt.myproject.service.api.EmployeeService;
import org.mybatis.spring.annotation.MapperScan;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service("employeeService")
@MapperScan("com.xlt.myproject.mapper")
public class EmployeeServiceImpl implements EmployeeService, Serializable {
    @Autowired
    private IemployeeDao iemployeeDao;

    @Override
    public EmployeeResponse findAllEmployees() {

        EmployeeResponse employeeResponse = new EmployeeResponse();
        List<Employee> list = new ArrayList<>();
        try {
            list = iemployeeDao.findEmployeeAll();
            if (list.size() > 0) {
                employeeResponse.setResult(list);
                employeeResponse.setCode("200");
                employeeResponse.setMessage("find all employees successfully.");
                employeeResponse.setStatus(Constant.Status.SUCCESS);
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
            employeeResponse.setCode("500");
            employeeResponse.setMessage("find all employees failed.");
            employeeResponse.setStatus(Constant.Status.FAIL);
        }

        return employeeResponse;
    }

    @Override
    public EmployeeResponse findEmployees(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        List<Employee> list = new ArrayList<>();
        try {
            list = iemployeeDao.findEmployeeByCondition(employee);
            if (list.size() > 0) {
                employeeResponse.setResult(list);
                employeeResponse.setCode("200");
                employeeResponse.setMessage("find employee by condition successfully.");
                employeeResponse.setStatus(Constant.Status.SUCCESS);
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
            employeeResponse.setCode("500");
            employeeResponse.setMessage("find employee by condition failed.");
            employeeResponse.setStatus(Constant.Status.FAIL);
        }
        return employeeResponse;
    }
}
