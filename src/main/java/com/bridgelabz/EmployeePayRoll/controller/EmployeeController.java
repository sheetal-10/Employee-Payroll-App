package com.bridgelabz.EmployeePayRoll.controller;

import com.bridgelabz.EmployeePayRoll.dto.EmployeeDto;
import com.bridgelabz.EmployeePayRoll.entity.Employee;
import com.bridgelabz.EmployeePayRoll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/addEmployee")
    public Employee addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

}
