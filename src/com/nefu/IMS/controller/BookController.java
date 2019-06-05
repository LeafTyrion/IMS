package com.nefu.IMS.controller;

import com.nefu.IMS.Utils.DBUtils;
import com.nefu.IMS.Utils.DateUtil;
import com.nefu.IMS.Utils.SleepUtil;
import com.nefu.IMS.entity.Book;
import com.nefu.IMS.entity.User;
import com.nefu.IMS.entity.UserBook;
import com.nefu.IMS.service.LoginService;

import java.util.List;

public class BookController {

    private DateUtil dateUtil = new DateUtil();
    private DBUtils dbUtils = new DBUtils();
    private List<Book> bookList = dbUtils.getBooksList();
    private List<UserBook> userBookList = dbUtils.getUserBookList();
    private List<User> userList = dbUtils.getUsersList();
    private int uid = LoginService.uid;

    //    图书状态控制
    public void userBookStatus() {
        for (UserBook userBook : userBookList) {
            if (dateUtil.compareDate(userBook.getReturnTime(), dateUtil.getNowDate()) &&
                    userBook.getBookStatus().equals("借阅中")) {
                userBook.setBookStatus("逾期未还");
            }
        }
        dbUtils.setUserBookList(userBookList);
    }

    //    判断当前用户是否可以继续借书
    public boolean canBor(int uid) {
        for (User user : userList) {
            if (user.getId() == uid) {
                if (user.getBoredBookNum() < 3) {
                    return true;
                } else {
                    System.out.println("借书失败");
                    System.out.println("每位用户只能借阅三本图书！您已借阅三本！");
                    SleepUtil.sleep();
                    return false;
                }
            }
        }
        System.out.println("此用户不存在！");
        SleepUtil.sleep();
        return false;
    }


    //    判断图书库存是否充足
    public boolean isEnough(int bid) {
        for (Book book : bookList) {
            if (book.getId() == bid) {
                if (book.getBookNum() > 0) {
                    return true;
                } else {
                    System.out.println("借阅失败！此图书库存不足！");
                    SleepUtil.sleep();
                    return false;
                }
            }
        }
        System.out.println("借阅失败！此图书不存在！");
        SleepUtil.sleep();
        return false;
    }

    //    判断所还图书是否存在
    public boolean exitBook(int bid) {
        for (Book book : bookList) {
            if (book.getId() == bid) {
                return true;
            }
        }
        System.out.println("借阅失败！此图书不存在！");
        SleepUtil.sleep();
        return false;
    }

    //    判断当前用户是否借过此书并且未还
    public boolean isBored(int bid) {
        for (UserBook userBook : userBookList) {
            if (userBook.getBook().getId() == bid &&
                    userBook.getUser().getId() == uid &&
                    (userBook.getBookStatus().equals("逾期未还") ||
                            (userBook.getBookStatus().equals("借阅中")))) {
                return true;
            }
        }
        System.out.println("还书失败！您未借阅该图书！");
        SleepUtil.sleep();
        return false;
    }

}