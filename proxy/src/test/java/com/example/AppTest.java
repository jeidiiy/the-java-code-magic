package com.example;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void proxy() {
        BookService bookService = new ProxyBookService();
        Book book = new Book("Demian", "Hello Demian", "Hermann Hesse");

        bookService.rent(book);
    }
}
