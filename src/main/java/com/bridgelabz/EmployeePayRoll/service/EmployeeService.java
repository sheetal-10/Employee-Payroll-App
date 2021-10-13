package com.bridgelabz.EmployeePayRoll.service;

import com.bridgelabz.EmployeePayRoll.dto.EmployeeDto;
import com.bridgelabz.EmployeePayRoll.entity.Employee;
import com.bridgelabz.EmployeePayRoll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Layer contains business logic,
 * It implements all the methods in controller layer
 * @author - Sheetal Panda
 * @version - 0.0.1
 * @since - 11/10/2021
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Function to get list of employess from database
     * @return list of employees
     */
    public List<Employee> employees() {
        return employeeRepository.findAll();
    }

    /**
     * Function to add employees to the database
     * @param employeeDto employee data from client
     * @return employees added
     */
    public Employee addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        return employeeRepository.save(employee);
    }

    /**
     * Function to edit the available employee in the database
     * @param id unique id of the employee
     * @param employeeDto  data from client
     * @return updated employee entry
     */
    public Employee updateEmployee(int id, EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(employeeDto.getName());
            employee.setSalary(employeeDto.getSalary());
            return employeeRepository.save(employee);
        }
        return null;
    }

    /**
     * Function to particular employee from database and delete it
     * @param id unique id of the employee
     * @return String message displaying status of operation
     */
    public String deleteEmployee(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepository.delete(optionalEmployee.get());
            return "Record deleted successfully";
        }
        return "Record does not exists with this id : " + id;
    }
}
