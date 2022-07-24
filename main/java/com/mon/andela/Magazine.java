package com.mon.andela;

import java.util.Date;
import java.util.List;

public class Magazine extends GenericBook implements IRead{

    private String name;

    private Date publicationDate;

    public Magazine(List<String> pages) {
        super(pages);
    }

    public Magazine(String name, Date publicationDate, List<String> pages) {
        super(pages);
        this.name = name;
        this.publicationDate = publicationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String readPage(int pageNo) {
        return pages.get(pageNo);
    }
}
