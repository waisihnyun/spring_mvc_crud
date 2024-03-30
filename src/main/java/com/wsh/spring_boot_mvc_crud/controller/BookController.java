package com.wsh.spring_boot_mvc_crud.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.wsh.spring_boot_mvc_crud.model.Book;
import com.wsh.spring_boot_mvc_crud.service.BookService;
import com.wsh.spring_boot_mvc_crud.validation.BookValidator;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new BookValidator());
    }

    @GetMapping
    String getAllBooks(Model model) {
        List<Book> books = this.bookService
                .getAllBooks();
        model.addAttribute("books", books);
        return "books/index";
    }

    @GetMapping("/{id}")
    String getBookById(@PathVariable int id) {
        Book book = this.bookService.getBookById(id);
        return "hello";
    }

    @GetMapping("/new")
    String bookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/books/newBook";
    }

    @PostMapping("/new")
    String createBook(@Valid @ModelAttribute Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("form has error");
            return "/books/newBook";
        }
        this.bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    String bookEditForm(Model model, @PathVariable String id) {
        Book book = this.bookService.getBookById(Integer.parseInt(id));
        model.addAttribute("book", book);
        return "/books/editBook";
    }

    @PostMapping("/edit/{id}")
    String updateBook(Model model, @Valid @ModelAttribute Book book, BindingResult result) {
        if (result.hasErrors()) {
            log.info("An error occurs");
            model.addAttribute(book);
            return "/books/editBook";
        } else {
            this.bookService.updateBook(book);
            return "redirect:/books";
        }
    }

    @GetMapping("/delete/{id}")
    String deleteBook(Model model, @PathVariable String id) {
        this.bookService.deleteBookById(Integer.parseInt(id));
        return "redirect:/books";
    }
}
