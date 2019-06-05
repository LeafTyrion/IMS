package com.nefu.IMS.entity;

public class UserBook {
    private int id;
    private User user;
    private Book book;
    private String bookStatus;
    private String borTime;
    private String returnTime;
    private String virReTime="";

    public UserBook(int id,User user, Book book, String bookStatus, String borTime, String returnTime) {
        this.id=id;
        this.user = user;
        this.book = book;
        this.bookStatus = bookStatus;
        this.borTime = borTime;
        this.returnTime = returnTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getBorTime() {
        return borTime;
    }

    public void setBorTime(String borTime) {
        this.borTime = borTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getVirReTime() {
        return virReTime;
    }

    public void setVirReTime(String virReTime) {
        this.virReTime = virReTime;
    }

    @Override
    public String toString() {
        return user.getId() +"\t\t\t" +
                user.getName()+"\t\t\t" +
                book.getId()+"\t\t\t" +
                book.getName()+"\t\t" +
                bookStatus + "\t\t\t" +
                borTime +"\t\t" +
                returnTime +"\t\t" +
                virReTime;
    }
}
