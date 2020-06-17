package com.southwind.springboottest.repository;

import com.southwind.springboottest.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jws.Oneway;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());

    }
    @Test
    void save(){
        Book book = new Book();
        book.setName("Spring Boot");
        book.setAuthor("张三");
        Book book1 = bookRepository.save(book);
        System.out.println(bookRepository.save(book));
    }
    @Test
    void findById(){
        Book book = bookRepository.findById(1).get();
        System.out.println(book);

    }

    @Test
    void update(){
        Book book = new Book();
        book.setId(120);
        book.setName("ajax");
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
    }

    @Test
    void delete(){
        bookRepository.deleteById(2);
    }
}