package com.emre1n.buchhandlung.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookRestExceptionHandler {

    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException (BookNotFoundException exc) {

        // create a BookErrorResponse

        BookErrorResponse error = new BookErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException(Exception exc) {

        // create a BookErrorResponse

        BookErrorResponse error = new BookErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(
                "Please check your input and try again.");
        error.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
