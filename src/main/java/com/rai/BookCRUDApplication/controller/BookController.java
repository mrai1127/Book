package com.rai.BookCRUDApplication.controller;

import com.rai.BookCRUDApplication.model.Book;
import com.rai.BookCRUDApplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book bookObj = bookService.addBook(book);
        return new ResponseEntity<>(bookObj, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBook(){
        List<Book> book = bookService.getAllBooks();
        return ResponseEntity.ok(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
       Optional<Book> books = bookService.getBookById(id);
       return ResponseEntity.ok(books.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id){
        Book book1= bookService.updateBookById(id);
        return ResponseEntity.ok(book1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.ok("Account has been deleted");
    }
}
