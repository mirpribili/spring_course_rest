package com.example.restapi.controller;

import com.example.restapi.entity.Employee;
import com.example.restapi.execption_handling.NoSuchEmployeeException;
import com.example.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id); // благодаря  <artifactId>jackson-databind</artifactId> на выходе будет JSON

        if(employee == null){
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in DB.");
        }

        return employee;
    }
}
