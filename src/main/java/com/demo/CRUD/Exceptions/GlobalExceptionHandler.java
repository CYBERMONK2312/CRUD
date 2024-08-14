package com.demo.CRUD.Exceptions;

import com.demo.CRUD.ExceptionDTO.BookErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BookNotFoundException.class})
    public ResponseEntity<BookErrorResponse> handleException(BookNotFoundException e) {
        BookErrorResponse error = new BookErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


}
