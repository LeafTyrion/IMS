package com.nefu.IMS.Utils;

import com.nefu.IMS.DataBase.DataBase;
import com.nefu.IMS.entity.Book;
import com.nefu.IMS.entity.User;
import com.nefu.IMS.entity.UserBook;

import java.util.List;

public class DBUtils {
    private List<UserBook> userBookList = DataBase.getUserBookList();
    private List<User> userList = DataBase.getUsersList();
    private List<Book> bookList = DataBase.getBooksList();
    private DateUtil dateUtil = new DateUtil();

    //  添加图书
    public void addBook(Book book) {
        bookList.add(book);
    }

    //    添加userBook
    public void addUserBook(int uid, int bid) {
        int id=DataBase.getUserBookList().size()+1;
        DataBase.getUserBookList().add(new UserBook(id,getUser(uid), getBook(bid),
                "借阅中", dateUtil.getNowDate(), dateUtil.getReDate(dateUtil.getNowDate())));
    }

    public List<UserBook> getUserBookList() {
        return userBookList;
    }

    //重设用户图书
    public void setUserBookList(List<UserBook> userBookList) {
        DataBase.setUserBookList(userBookList);
    }

    public List<User> getUsersList() {
        return userList;
    }

//    public void setUserList(List<User> userList) {
//        DataBase.setUsersList(userList);
//    }

    //    展示全部图书
    public List<Book> getBooksList() {
        return bookList;
    }

//    public void setBookList(List<Book> bookList) {
//        DataBase.setBooksList(bookList);
//    }

    //    得到id为bid的书
    public Book getBook(int bid) {
        for (Book book : bookList) {
            if (book.getId() == bid) {
                return book;
            }
        }
        return null;
    }

    //    更新图书数量
    public void setBook(int num, int bid) {
        for (Book book : bookList) {
            if (book.getId() == bid) {
                book.setBookNum(num);
            }
        }
    }

    //    得到id为uid的用户
    public User getUser(int uid) {
        for (User user : userList) {
            if (user.getId() == uid) {
                return user;
            }
        }
        return null;
    }

    //    更新用户可借书数量
    public void setUser(int num, int uid) {
        for (User user : userList) {
            if (uid == user.getId()) {
                user.setBoredBookNum(num);
            }
        }
    }

    //    得到指定uid和bid的逾期未还的userbook的id
    public int getUserBookid(int uid, int bid) {
        for (UserBook userBook : userBookList) {
            if (userBook.getBook().getId() == bid &&
                    userBook.getUser().getId() == uid &&
                    (userBook.getBookStatus().equals("逾期未还") ||
                            (userBook.getBookStatus().equals("借阅中")))) {
                return userBook.getId();
            }
        }
        return 0;
    }
    //    得到指定uid和bid的逾期未还的userbook
    public UserBook getUserBook(int id) {
        for (UserBook userBook : userBookList) {
            if (userBook.getId()==id) {
                return userBook;
            }
        }
        return null;
    }
    //    更新指定uid和bid的userbook
    public void setUserBook(int id, String status, String virReTime) {
        for (UserBook userBook : userBookList) {
            if (userBook.getId() == id ) {
                userBook.setBookStatus(status);
                userBook.setVirReTime(virReTime);
                break;
            }
        }
    }
}
