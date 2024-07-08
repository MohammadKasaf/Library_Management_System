package com.LibraryManagementSystem.services;

import com.LibraryManagementSystem.models.Book;
import com.LibraryManagementSystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void saveBook(Book book){

        bookRepository.save(book);
    }

    public Book findById(int id){

        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getAllBooks(){

        return bookRepository.findAll();
    }

    public void deleteBookById(int id){

        bookRepository.deleteById(id);
    }

}

