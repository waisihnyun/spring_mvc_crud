package com.wsh.spring_boot_mvc_crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wsh.spring_boot_mvc_crud.dao.BookDao;
import com.wsh.spring_boot_mvc_crud.model.Book;
import com.wsh.spring_boot_mvc_crud.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> getAllBooks() {
        return this.bookDao.getAllBooks();
    }

    @Override
    public Book getBookById(int id) {
        return this.bookDao.getBookById(id);
    }

    @Override
    public void saveBook(Book book) {
        int bookCount = this.bookDao.getAllBooks().size();
        book.setId(bookCount + 1);
        this.bookDao.saveBook(book);
    }

    @Override
    public void updateBook(Book book) {
        this.bookDao.updateBook(book);
    }

    @Override
    public void deleteBookById(int id) {
        this.bookDao.deleteBookById(id);
    }
}
