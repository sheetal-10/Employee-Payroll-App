package com.bridgelabz.EmployeePayRoll.controller;

import com.bridgelabz.EmployeePayRoll.dto.EmployeeDto;
import com.bridgelabz.EmployeePayRoll.entity.Employee;
import com.bridgelabz.EmployeePayRoll.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Layer that receives various HTTP request from client
 * @author - Sheetal Panda
 * @version - 0.0.1
 * @since - 11/10/2021
 */
@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Function to receive get request from client
     * @return list of employees
     */
    @GetMapping(value = "/employees")
    public List<Employee> employees() {
        return employeeService.employees();
    }

    /**
     * Function to receive post request from client
     * @param employeeDto employee data from client
     * @return added employee in the database
     */
    @PostMapping(value = "/addEmployee")
    public Employee addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    /**
     * Function to receive put request from client
     * @param id unique id of the employee
     * @return updated employee details
     */
    @PutMapping(value = "/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody EmployeeDto employeeDto) {
        log.info(employeeDto.toString());
        return employeeService.updateEmployee(id, employeeDto);
    }

    /**
     * Function to delete employee from client
     * @param id unique id of the employee
     * @return String message displaying status of operation
     */
    @DeleteMapping(value = "/deleteEmployee")
    public String deleteEmployee(@RequestParam int id) {
        return employeeService.deleteEmployee(id);
    }

}
