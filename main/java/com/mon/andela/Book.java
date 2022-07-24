package com.mon.andela;

import java.util.List;

public class Book extends GenericBook implements IRead{

    private String title;
    private String author;

    public Book(List<String> pages) {
        super(pages);
    }

    public Book(String title, String author, List<String> pages) {
        super(pages);
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String readPage(int pageNo){
        return pages.get(pageNo);
    }
}
