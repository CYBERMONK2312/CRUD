package com.demo.CRUD.Repository;

import com.demo.CRUD.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer>{
    @Modifying
    @Transactional
    @Query("UPDATE BookEntity b SET b.name = :bookName, b.author = :bookAuthor, b.price = :bookPrice, b.description = :bookDescription WHERE b.id = :bookId")
    void updateBookDetails(Integer bookId, String bookName, String bookAuthor, double bookPrice, String bookDescription);

}