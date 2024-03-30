package com.wsh.spring_boot_mvc_crud.service;

import com.wsh.spring_boot_mvc_crud.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(int id);
    void saveBook(Book book);
    void updateBook(Book book);
    void deleteBookById(int id);
}
