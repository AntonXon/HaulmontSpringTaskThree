package ru.haulmont.taskthree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.haulmont.taskthree.entity.Book;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

}
