package com.nefu.IMS.entity;

public class Book {
    private int id;
    private String name;
    private int bookNum;

    public Book(int id, String name, int bookNum) {
        this.id = id;
        this.name = name;
        this.bookNum = bookNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    @Override
    public String toString() {
        return  id + "\t\t\t" +
                name + "\t\t" +
                bookNum;
    }
}
