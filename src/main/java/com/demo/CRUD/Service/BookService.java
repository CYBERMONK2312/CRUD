package com.demo.CRUD.Service;

import com.demo.CRUD.BookDTO.BookDTO;
import com.demo.CRUD.Entity.BookEntity;
import com.demo.CRUD.Exceptions.BookNotFoundException;
import com.demo.CRUD.Repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;



    public BookDTO saveBook(BookDTO bookDTO) {
            BookEntity bookEntity = modelMapper.map(bookDTO,BookEntity.class);
            BookEntity saveBook = bookRepository.save(bookEntity);
            return modelMapper.map(saveBook,BookDTO.class);
    }

    public BookEntity getBook(Integer Book_id){
        Optional<BookEntity> opt = Optional.ofNullable(bookRepository.findById(Book_id).orElseThrow(() -> new BookNotFoundException("Book with Id " + Book_id + " not found! ")));
        return opt.get();


//        if(opt.isPresent()){
//            return opt.get();
//        }
//        else
//        return null;
    }
//
    public List<BookEntity> getAllBooks() {
       return bookRepository.findAll();
    }
//
    public void deleteBook(Integer book_id) {
        bookRepository.deleteById(book_id);
    }

    public void updateBookById(Integer bookId, BookDTO bookDTO) {
        BookEntity bookEntity = modelMapper.map(bookDTO,BookEntity.class);
        bookRepository.updateBookDetails(bookId,
                bookEntity.getName(),
                bookEntity.getAuthor(),
                bookEntity.getPrice(),
                bookEntity.getDescription());
    }

    public List<BookDTO> getDataByPaging(Integer pageNo){
        Pageable page=PageRequest.of(pageNo,10,Sort.by("id"));
        List<BookEntity> book = bookRepository.findAll(page).getContent();

        return book.stream()
                .map(b->modelMapper.map(b,BookDTO.class))
                .toList();
       }

//    public List<BookDTO> getDataByPaging(Integer pageNo) {
//        // Adjust sorting property if necessary
//        Pageable page = PageRequest.of(pageNo, 10, Sort.by("price"));
//
//        // Retrieve page of BookEntity from the repository
//        Page<BookEntity> bookPage = bookRepository.findAll(page);
//        List<BookEntity> bookList = bookPage.getContent();
//
//        // Convert to BookDTO
//        return bookList.stream()
//                .map(b -> modelMapper.map(b, BookDTO.class))
//                .collect(Collectors.toList());
//    }
}
