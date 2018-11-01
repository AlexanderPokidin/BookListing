package com.pokidin.a.booklisting;

import java.util.List;

public class Book {

    private String title;
    private String publisher;
    private String publishedDate;
    private String description;
    private List<String> authors;

    public Book(String title, String publisher, String publishedDate, String description, List<String> authors) {
        this.title = title;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
