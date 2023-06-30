package com.project.book.controller;

import com.project.book.entities.Book;
import com.project.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping(path = "/books")
    public List<Book> getBooks(){
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable ("id") int id){
        return bookService.getBookById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        Book b=this.bookService.addBook(book);
        return b;
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable("bookId") int bookId){
        this.bookService.deleteBook(bookId);
        return "Deleted";
    }
    @PutMapping("/books/{bookId}")
    public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
        this.bookService.updateBook(book,bookId);
        return book;
    }
}
