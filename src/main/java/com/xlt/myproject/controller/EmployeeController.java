package com.xlt.myproject.controller;


import com.xlt.myproject.model.Employee;
import com.xlt.myproject.model.EmployeeResponse;
import com.xlt.myproject.service.api.EmployeeService;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *@RestController(value="/employee")
 * 里面的value代表的是EmployeeController类生成的bean的名字
* */
@RestController(value="employeeController")
@RequestMapping("/employee")
public class EmployeeController {
    private static Logger logger = Logger.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/getList", method = RequestMethod.GET, produces="application/json")
    public EmployeeResponse getList() {
        logger.info("EmployeeController.getList()");
         EmployeeResponse employeeResponse =  employeeService.findAllEmployees();
         return employeeResponse;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces="application/json")
    public EmployeeResponse searchEmployee(@Param("employee") Employee employee){
        logger.info("EmployeeController.searchEmployee() input info:"+employee.toString());
        EmployeeResponse employeeResponse=employeeService.findEmployees(employee);
        return employeeResponse;
    }
}
