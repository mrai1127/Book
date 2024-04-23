package com.rai.BookCRUDApplication.service;

import com.rai.BookCRUDApplication.model.Book;
import com.rai.BookCRUDApplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book){
        Book book1 = bookRepository.save(book);
        return book1;
    }

    public List<Book> getAllBooks(){
      List <Book> book = new ArrayList<>();
      bookRepository.findAll().forEach(book::add);
       return book;
    }

    public Optional<Book> getBookById(Long id){
        Optional<Book> books = bookRepository.findById(id);
        return books;
    }

    public Book updateBookById(Long id) {
            Book savedBook = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist with id:" + id));
            return savedBook;
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
