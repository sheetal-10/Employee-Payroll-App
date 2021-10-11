package com.bridgelabz.EmployeePayRoll.repository;

import com.bridgelabz.EmployeePayRoll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Layer that implements interface and does the database operations
 * @author - Sheetal Panda
 * @version - 0.0.1
 * @since - 11/10/2021
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
