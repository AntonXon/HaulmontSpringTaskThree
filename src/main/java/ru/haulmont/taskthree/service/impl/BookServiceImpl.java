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
    @Value("${book.defaultManufacturer}")
    private String defaultManufacturer;
    private BookRepository bookRepository;

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        books.forEach(book -> {
            BookDto bookDto = new BookDto();
            bookDto.setId(book.getId());
            bookDto.setName(book.getName());
            bookDto.setManufacturer(defaultManufacturer);
            bookDto.setYearOfPublishing(book.getYearOfPublishing());
            bookDtoList.add(bookDto);
        });
        return bookDtoList;
    }

    @Override
    public void createBook(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setYearOfPublishing(bookDto.getYearOfPublishing());
        book.setManufacturer(bookDto.getManufacturer());
        bookRepository.save(book);
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
