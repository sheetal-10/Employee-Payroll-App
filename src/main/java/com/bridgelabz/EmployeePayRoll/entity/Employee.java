package com.bridgelabz.EmployeePayRoll.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Layer that contains the entities in the database
 * @author - Sheetal Panda
 * @version - 0.0.1
 * @since - 11/10/2021
 */
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int salary;
}
