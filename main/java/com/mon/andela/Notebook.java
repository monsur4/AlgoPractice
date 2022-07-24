package com.mon.andela;

import java.util.List;

public class Notebook extends GenericBook implements IRead{

    private String owner;

    public Notebook(List<String> pages) {
        super(pages);
    }

    public Notebook(String owner, List<String> pages) {
        super(pages);
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String readPage(int pageNo) {
        return pages.get(pageNo);
    }
}
