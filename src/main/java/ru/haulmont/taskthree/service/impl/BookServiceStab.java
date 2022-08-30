package ru.haulmont.taskthree.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.haulmont.taskthree.dto.BookDto;
import ru.haulmont.taskthree.service.BookService;

import java.util.List;
import java.util.UUID;

@Service
@Profile("dev")
public class BookServiceStab implements BookService {
    @Value("${book.defaultManufacturer}")
    private String defaultManufacturer;
    @Value("${book.defaultName}")
    private String defaultName;
    @Value("${book.defaultYear}")
    private int defaultYear;

    @Override
    public List<BookDto> getAllBooks() {
        BookDto bookDto = new BookDto();
        bookDto.setId(UUID.randomUUID());
        bookDto.setName(defaultName);
        bookDto.setYearOfPublishing(defaultYear);
        bookDto.setManufacturer(defaultManufacturer);
        return List.of(bookDto);
    }

    @Override
    public void createBook(BookDto bookDto) {

    }
}
