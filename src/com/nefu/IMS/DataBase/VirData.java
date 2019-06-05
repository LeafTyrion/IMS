package com.nefu.IMS.DataBase;

import com.nefu.IMS.entity.Book;
import com.nefu.IMS.entity.User;
import com.nefu.IMS.entity.UserBook;

import java.util.ArrayList;
import java.util.List;

public class VirData {

    private static User user01 = new User(111, "张三", "111111", 2);
    private static User user02 = new User(222, "李四", "222222", 1);
    private static User user03 = new User(333, "王五", "333333", 0);

    private static Book book01 = new Book(1, "软件工程导论", 99);
    private static Book book02 = new Book(2, "Java基础教程", 49);
    private static Book book03 = new Book(3, "计算机网络", 0);
    private static Book book04 = new Book(4, "计算机操作系统", 0);
    private static Book book05 = new Book(5, "数据结构与算法", 9);

    private static UserBook userBook01 = new UserBook(1,user01, book01, "借阅中",
            "2019-02-03 10:32:30", "2019-04-05 10:32:30");
    private static UserBook userBook02 = new UserBook(2,user01, book02, "借阅中",
            "2019-04-03 10:32:30", "2019-06-05 10:32:30");
    private static UserBook userBook03 = new UserBook(3,user02, book03, "借阅中",
            "2019-05-03 10:32:30", "2019-07-05 10:32:30");


    public static void user() {
        List<User> userList = new ArrayList<>();
        userList.add(user01);
        userList.add(user02);
        userList.add(user03);
        DataBase.setUsersList(userList);
    }

    public static void book() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(book01);
        bookList.add(book02);
        bookList.add(book03);
        bookList.add(book04);
        bookList.add(book05);
        DataBase.setBooksList(bookList);

    }

    public static void userBook() {
        List<UserBook> userBookList = new ArrayList<>();
        userBookList.add(userBook01);
        userBookList.add(userBook02);
        userBookList.add(userBook03);
        DataBase.setUserBookList(userBookList);
    }

}
