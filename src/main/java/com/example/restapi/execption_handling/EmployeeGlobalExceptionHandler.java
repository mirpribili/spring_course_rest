package com.example.restapi.execption_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {
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
