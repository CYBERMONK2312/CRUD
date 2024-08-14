package com.demo.CRUD.ExceptionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BookErrorResponse {
    public int status;

    public String message;


    public BookErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
