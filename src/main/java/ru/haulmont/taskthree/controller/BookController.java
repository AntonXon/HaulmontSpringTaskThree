package ru.haulmont.taskthree.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.haulmont.taskthree.dto.BookDto;
import ru.haulmont.taskthree.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<String> createBook(@RequestParam String name, @RequestParam String manufacturer, @RequestParam int year) {
        BookDto bookDto = new BookDto();
        bookDto.setName(name);
        bookDto.setManufacturer(manufacturer);
        bookDto.setYearOfPublishing(year);
        bookService.createBook(bookDto);
        return new ResponseEntity<>("Success", HttpStatus.OK);

    }
}
