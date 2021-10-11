package com.bridgelabz.EmployeePayRoll.controller;

import com.bridgelabz.EmployeePayRoll.dto.EmployeeDto;
import com.bridgelabz.EmployeePayRoll.entity.Employee;
import com.bridgelabz.EmployeePayRoll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public List<Employee> employees() {
        return employeeService.employees();
    }

    @PostMapping(value = "/addEmployee")
    public Employee addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    @PutMapping(value = "/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(id, employeeDto);
    }

}
