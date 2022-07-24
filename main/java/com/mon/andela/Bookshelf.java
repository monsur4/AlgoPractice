package com.mon.andela;

import java.util.ArrayList;
import java.util.List;

public class Bookshelf<T extends GenericBook> {

//    Define the classes and their methods (including parameters and return types) for a system that consist of a bookshelf, books, magazines, and notebooks.
//
//    The bookshelf should allow store and retrieval of the items, reporting on the state of the bookshelf (how many items it has, how many more items it can hold), and searching for items based on the page contents.
//
//    The other items should allow reading of a single page given the page number that returns the text of the page.
//
//    A book has an accessible title and author.
//
//    A magazine has an accessible name and publication date.
//
//    A notebook has an accessible owner.

    private List<T> bookItems;
    private int size;

    public Bookshelf(int size) {
        bookItems = new ArrayList<>();
        this.size = size;
    }

    public void addBook(T item){
        bookItems.add(item);
    }

    public T retrieveBook(T item){
        bookItems.remove(item);
        return item;
    }

    public boolean isBookShelfEmpty(){
        return bookItems.isEmpty();
    }

    public int noOfItems(){
        return bookItems.size();
    }

    /**
     * returns the number of items that can still be added to the bookshelf
     */
    public int noOfAvailableSlots(){
        return size - noOfItems();
    }

    public T search(String pageContent){
        return bookItems.stream().filter(item -> item.pages.contains(pageContent)).findFirst().orElse(null);
    }
}
