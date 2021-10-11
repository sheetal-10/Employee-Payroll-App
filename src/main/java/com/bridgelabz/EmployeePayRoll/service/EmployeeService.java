package com.bridgelabz.EmployeePayRoll.service;

import com.bridgelabz.EmployeePayRoll.dto.EmployeeDto;
import com.bridgelabz.EmployeePayRoll.entity.Employee;
import com.bridgelabz.EmployeePayRoll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> employees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setSalary(employeeDto.getSalary());
        return employeeRepository.save(employee);
    }


    public Employee updateEmployee(int id, EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(employeeDto.getName());
            employee.setSalary(employeeDto.getSalary());
            return employee;
        }
        return null;
    }

    public String deleteEmployee(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepository.delete(optionalEmployee.get());
            return "Record deleted successfully";
        }
        return "Record does not exists with this id : " + id;
    }
}
