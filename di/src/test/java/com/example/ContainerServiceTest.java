package com.example;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ContainerServiceTest {

    @Test
    public void getObject() {
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertNotNull(bookRepository);
    }

    @Test
    public void getObject_BookService() {
        BookService bookService = ContainerService.getObject(BookService.class);
        assertNotNull(bookService);
        assertNotNull(bookService.bookRepository);
    }
}
