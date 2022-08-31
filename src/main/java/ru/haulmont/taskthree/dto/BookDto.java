package ru.haulmont.taskthree.dto;

import java.util.UUID;

public class BookDto {
    private UUID id;
    private String name;
    private int yearOfPublishing;
    private String manufacturer;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public static class BookDtoBuilder {
        private UUID id;
        private String name;
        private int yearOfPublishing;
        private String manufacturer;

        public BookDtoBuilder setId(UUID id) {
            this.id = id;
            return this;
        }

        public BookDtoBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BookDtoBuilder setYearOfPublishing(int yearOfPublishing) {
            this.yearOfPublishing = yearOfPublishing;
            return this;
        }

        public BookDtoBuilder setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public BookDto build() {
            BookDto bookDto = new BookDto();
            bookDto.setId(this.id);
            bookDto.setYearOfPublishing(this.yearOfPublishing);
            bookDto.setName(this.name);
            bookDto.setManufacturer(this.manufacturer);
            return bookDto;
        }
    }
}


