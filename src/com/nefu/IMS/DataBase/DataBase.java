package com.nefu.IMS.DataBase;

import com.nefu.IMS.entity.Book;
import com.nefu.IMS.entity.User;
import com.nefu.IMS.entity.UserBook;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static List<User> usersList=new ArrayList<>();
    private static List<Book> booksList=new ArrayList<>();
    private static List<UserBook> userBookList=new ArrayList<>();

    public static List<User> getUsersList() {
        return usersList;
    }

    public static void setUsersList(List<User> usersList) {
        DataBase.usersList = usersList;
    }

    public static List<Book> getBooksList() {
        return booksList;
    }

    public static void setBooksList(List<Book> booksList) {
        DataBase.booksList = booksList;
    }

    public static List<UserBook> getUserBookList() {
        return userBookList;
    }

    public static void setUserBookList(List<UserBook> userBookList) {
        DataBase.userBookList = userBookList;
    }
}
