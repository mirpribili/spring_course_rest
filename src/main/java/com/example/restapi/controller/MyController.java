package com.example.restapi.controller;

import com.example.restapi.entity.Employee;
import com.example.restapi.execption_handling.EmployeeIncorrectData;
import com.example.restapi.execption_handling.NoSuchEmployeeException;
import com.example.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // http://localhost:8080/spring_course_rest/api/employees/100500
    @ExceptionHandler
    // _ обертка HTTP response
    public ResponseEntity<
            // _ тип объекта который добавляется в HTTP response body
            EmployeeIncorrectData> handleException(
                    // _ Exception на который должен реагировать данный метод
            NoSuchEmployeeException exception
    ){
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    //  http://localhost:8080/spring_course_rest/api/employees/aaaaaa
    @ExceptionHandler
    // _ обертка HTTP response
    public ResponseEntity<
            // _ тип объекта который добавляется в HTTP response body
            EmployeeIncorrectData> handleException(
            // _ Exception на который должен реагировать данный метод
            Exception exception
    ){
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
