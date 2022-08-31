package ru.haulmont.taskthree.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Book {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ID", nullable = false)
    private UUID id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "PUBLISHING_YEAR", nullable = false)
    private int yearOfPublishing;
    @Column(name = "MANUFACTURER", nullable = false)
    private String manufacturer;

    public UUID getId() {
        return id;
    }

    public Book setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public Book setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Book setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }
}
