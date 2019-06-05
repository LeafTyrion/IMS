package com.nefu.IMS.service;

import com.nefu.IMS.Utils.DBUtils;
import com.nefu.IMS.Utils.DateUtil;
import com.nefu.IMS.Utils.SleepUtil;
import com.nefu.IMS.controller.BookController;
import com.nefu.IMS.controller.OptionController;
import com.nefu.IMS.entity.Book;
import com.nefu.IMS.entity.UserBook;
import com.nefu.IMS.view.View;

import java.util.List;
import java.util.Scanner;

public class OptionService {
    private Scanner in = new Scanner(System.in);
    private DBUtils dbUtils = new DBUtils();
    private DateUtil dateUtil=new DateUtil();
    private int uid=LoginService.uid;
    private BookController bookController = new BookController();

    //    新增图书
    public void addBook() {
        System.out.println("请输入图书编号：");
        int id = in.nextInt();
        System.out.println("请输入图书名称：");
        String name = in.next();
        System.out.println("请输入图书数量：");
        int bookNum = in.nextInt();
        Book book = new Book(id, name, bookNum);
        dbUtils.addBook(book);
        System.out.println("新书录入成功！");
        SleepUtil.sleep();
        OptionController.option();
    }

    //    借书
    public void borBook() {
        bookController.userBookStatus();
        System.out.println("请输入要借的图书编号：");
        int bid = in.nextInt();
        int bookNum;
        int boredNum = dbUtils.getUser(uid).getBoredBookNum();
        if (bookController.exitBook(bid)) {
            bookNum = dbUtils.getBook(bid).getBookNum();
            if(bookController.isEnough(bid)) {
                if (bookController.canBor(uid)) {
                    bookNum--;
                    boredNum++;
                    dbUtils.getBook(bid).setBookNum(bookNum);
                    dbUtils.getUser(uid).setBoredBookNum(boredNum);
                    dbUtils.addUserBook(uid, bid);
                    System.out.println("借书成功！");
                    System.out.println("您还可以借阅" + (3 - boredNum) + "本书！");
                    SleepUtil.sleep();
                }
            }
        }
        OptionController.option();
    }

    //    还书
    public void retBook() {
        bookController.userBookStatus();
        System.out.println("请输入要还的图书编号：");
        int bid = in.nextInt();
        int bookNum;
        String status=null;
        int userBookId;
        UserBook userBook;
        int boredNum = dbUtils.getUser(uid).getBoredBookNum();
        if (bookController.exitBook(bid)) {
            bookNum=dbUtils.getBook(bid).getBookNum();
            if (bookController.isBored(bid)) {
                userBookId=dbUtils.getUserBookid(uid, bid);
                userBook=dbUtils.getUserBook(userBookId);
                bookNum++;
                boredNum--;
                if (userBook.getBookStatus().equals("逾期未还")) {
                    status="逾期已还";
                    System.out.println("逾期还书成功！下次请注意借阅时间为两个月！");
                } else if(userBook.getBookStatus().equals("借阅中")){
                    status="按时已还";
                    System.out.println("按时还书成功！");
                }
                System.out.println("您还能借" + (3 - boredNum) + "本书！");
                dbUtils.setUserBook(userBookId,status,dateUtil.getNowDate());
                dbUtils.setBook(bookNum, bid);
                dbUtils.setUser(boredNum, uid);
                SleepUtil.sleep();
            }
        }
        OptionController.option();
    }

    //    查询书籍状态
    public void queryBooks() {
        List<Book> bookList = dbUtils.getBooksList();
        boolean flag = true;
        View.bookStatus();
        System.out.println("请输入操作序号：");
        int option = in.nextInt();
        if (option == 1) {
            System.out.println("请输入图书编号：");
            int bid = in.nextInt();
            View.bookList();
            for(Book book:bookList){
                if(book.getId()==bid){
                    flag=false;
                    System.out.println(book);
                }
            }if(flag){
                System.out.println("您输入的图书编号有误或不存在记录！");
            }
            View.backStatus();
        } else if (option == 2) {
            View.bookList();
            for (Book book : bookList) {
                System.out.println(book);
            }
            View.backStatus();
        } else if (option == 0) {
            OptionController.option();
        } else {
            View.exception();
            queryBooks();
        }
    }


    //    查询借阅历史y
    public void history() {
        bookController.userBookStatus();
        List<UserBook> userBookList = dbUtils.getUserBookList();
        boolean flag = true;
        View.historyView();
        System.out.println("请输入操作序号：");
        int option = in.nextInt();
        if (option == 1) {
            System.out.println("请输入图书编号：");
            int bid = in.nextInt();
            View.historyList();
            for (UserBook userBook : userBookList) {
                if (userBook.getBook().getId() == bid) {
                    flag = false;
                    System.out.println(userBook);
                }
            }
            if (flag) {
                System.out.println("您输入的图书编号有误或不存在记录！");
            }
            View.backHistory();
        } else if (option == 2) {
            System.out.println("请输入用户编号：");
            int uid = in.nextInt();
            View.historyList();
            for (UserBook userBook : userBookList) {
                if (userBook.getUser().getId() == uid) {
                    flag = false;
                    System.out.println(userBook);
                }
            }
            if (flag) {
                System.out.println("您输入的用户编号有误或不存在记录！");
            }
            View.backHistory();
        } else if (option == 3) {
            View.historyList();
            for (UserBook userBook : userBookList) {
                System.out.println(userBook);
            }
            View.backHistory();
        } else if (option == 0) {
            OptionController.option();
        } else {
            View.exception();
            history();
        }
    }

}

