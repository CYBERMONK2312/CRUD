package com.demo.CRUD.Controller;

import com.demo.CRUD.BookDTO.BookDTO;
import com.demo.CRUD.Entity.BookEntity;
import com.demo.CRUD.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public BookDTO saveBook(@RequestBody @Valid BookDTO bookDTO){
        return bookService.saveBook(bookDTO);
    }

    @GetMapping("/get/{bookId}")
    public ResponseEntity<BookEntity>  getBook(@PathVariable Integer bookId){
        return new ResponseEntity<>(bookService.getBook(bookId), HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public List<BookEntity> getAllBooks(){
       return bookService.getAllBooks();
    }

    @DeleteMapping("/delete/{Book_id}")
    public void deleteBook(@PathVariable("Book_id")Integer Book_id){
        bookService.deleteBook(Book_id);
    }

    @PutMapping("/update/{bookId}")
    public void updateBook(@PathVariable("bookId") Integer bookId, @RequestBody BookDTO bookDTO){
        bookService.updateBookById(bookId, bookDTO);
    }

    @GetMapping("/page/{pageNo}")
    public List<BookDTO> getPage(@PathVariable("pageNo") Integer pageNo){
        return bookService.getDataByPaging(pageNo);
    }

}

