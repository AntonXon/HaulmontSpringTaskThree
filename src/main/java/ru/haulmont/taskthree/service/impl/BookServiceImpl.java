package ru.haulmont.taskthree.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.haulmont.taskthree.dto.BookDto;
import ru.haulmont.taskthree.entity.Book;
import ru.haulmont.taskthree.repository.BookRepository;
import ru.haulmont.taskthree.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("prod")
public class BookServiceImpl implements BookService {
    private final String defaultManufacturer;

    private final BookRepository bookRepository;

    public BookServiceImpl(@Value("${book.defaultManufacturer}") String defaultManufacturer, BookRepository bookRepository) {
        this.defaultManufacturer = defaultManufacturer;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        books.forEach(book -> {
            BookDto bookDto = new BookDto.BookDtoBuilder()
                    .setId(book.getId())
                    .setName(book.getName())
                    .setManufacturer(defaultManufacturer)
                    .setYearOfPublishing(book.getYearOfPublishing())
                    .build();
            bookDtoList.add(bookDto);
        });
        return bookDtoList;
    }

    @Override
    public void createBook(BookDto bookDto) {
        Book book = new Book()
                .setName(bookDto.getName())
                .setYearOfPublishing(bookDto.getYearOfPublishing())
                .setManufacturer(bookDto.getManufacturer());
        bookRepository.save(book);
    }
}
