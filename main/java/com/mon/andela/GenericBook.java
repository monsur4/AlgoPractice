package com.mon.andela;

import java.util.List;

public abstract class GenericBook {

    protected List<String> pages;

    public GenericBook(List<String> pages) {
        this.pages = pages;
    }

    public List<String> getPages() {
        return pages;
    }

    public void setPages(List<String> pages) {
        this.pages = pages;
    }
}
