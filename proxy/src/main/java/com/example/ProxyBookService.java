package com.example;

public class ProxyBookService implements BookService {

    BookService bookService = new DefaultBookService();

    @Override
    public void rent(Book book) {
        System.out.println(book.getContent());
        bookService.rent(book);
        System.out.println(book.getAuthor());
    }
}
