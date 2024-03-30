package com.wsh.spring_boot_mvc_crud.dao.impl;

import org.springframework.stereotype.Repository;
import com.wsh.spring_boot_mvc_crud.dao.BookDao;
import com.wsh.spring_boot_mvc_crud.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    List<Book> books;

    BookDaoImpl() {
        this.books = new ArrayList<Book>();
        this.books.add(new Book(1,"Test1", "Author1"));
        this.books.add(new Book(2,"Test2", "Author2"));
    }

    @Override
    public List<Book> getAllBooks() {
        return this.books;
    }

    @Override
    public Book getBookById(int id) {
        return this.books.stream()
                .filter(book -> book.getId().equals(id))
                .toList()
                .get(0);
    }

    @Override
    public void saveBook(Book book) {
        this.books.add(book);
    }

    @Override
    public void updateBook(Book book) {
        Book originalBook = this.getBookById(book.getId());
        originalBook.setTitle(book.getTitle());
        originalBook.setAuthor(book.getAuthor());
    }

    @Override
    public void deleteBookById(int id) {
        this.books = this.books.stream()
                .filter(book -> !book.getId().equals(id))
                .toList();
    }
}
