package ru.haulmont.taskthree.controller;


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

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<String> createBook(@RequestParam String name, @RequestParam String manufacturer, @RequestParam int year) {
        BookDto bookDto = new BookDto.BookDtoBuilder()
                .setName(name)
                .setManufacturer(manufacturer)
                .setYearOfPublishing(year).build();
        bookService.createBook(bookDto);
        return new ResponseEntity<>("Success", HttpStatus.OK);

    }
}
