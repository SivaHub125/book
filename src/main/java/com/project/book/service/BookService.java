package com.project.book.service;

import com.project.book.dao.BookRepository;
import com.project.book.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    //private static List<Book> list =new ArrayList<>();

    /*static {
        list.add(new Book(12,"Java","xyz"));
        list.add(new Book(45,"Python","yzx"));
        list.add(new Book(14,"C++","zxy"));
    }*/

    public List<Book> getAllBooks()
    {
        List<Book> list=(List<Book>)this.bookRepository.findAll();
        return list;
    }

    public Book getBookById(int id){
        Book book=null;
        try {
            book=this.bookRepository.findById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book b){
        Book result=bookRepository.save(b);
        return result;
    }
    public void deleteBook(int bid){
        //list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }

    public void updateBook(Book book ,int bid)
    {
        /*list=list.stream().map(b->{
            if(b.getId()==bid)
            {
                book.setTitle(book.getTitle());
                book.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());*/
        book.setId(bid);
        bookRepository.save(book);
    }


}
