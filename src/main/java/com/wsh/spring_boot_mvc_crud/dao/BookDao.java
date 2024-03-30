package com.wsh.spring_boot_mvc_crud.dao;

import com.wsh.spring_boot_mvc_crud.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();
    Book getBookById(int id);
    void saveBook(Book book);
    void updateBook(Book book);
    void deleteBookById(int id);
}
