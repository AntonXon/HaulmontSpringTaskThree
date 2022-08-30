package ru.haulmont.taskthree.service;

import ru.haulmont.taskthree.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks();
    void createBook(BookDto bookDto);
}
