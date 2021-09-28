package com.example;

public class Book {

    private String title;
    private String content;
    private String author;

    public Book() {
        this.title = "unknown";
        this.content = "unknown";
        this.author = "unknown";
    }

    public Book(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
