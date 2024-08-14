package com.demo.CRUD.BookDTO;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    @NotNull(message = "ID Cannot Be Empty")
    Integer id;

    @NotNull(message = " Name Cannot Be Empty!")
    String name;

    @DecimalMin(value = "10.00", message = "Minimum Value Must Be 10 !")
    Double price;

    @NotNull(message = "Author Name Cannot Be Empty!")
    String author;

    @Size(min = 10, max = 100 , message = "Description must be in between 10 to 100 Letters!")
    String description;
}
