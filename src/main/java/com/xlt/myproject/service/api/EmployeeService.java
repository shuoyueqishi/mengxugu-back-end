package com.xlt.myproject.service.api;

import com.xlt.myproject.model.Employee;
import com.xlt.myproject.model.EmployeeResponse;
public interface EmployeeService {
    EmployeeResponse findAllEmployees();
    EmployeeResponse findEmployees(Employee employee);
}
