package com.nefu.IMS.service;

import com.nefu.IMS.Utils.DBUtils;
import com.nefu.IMS.controller.OptionController;
import com.nefu.IMS.entity.User;
import com.nefu.IMS.view.View;

import java.util.List;
import java.util.Scanner;

public class LoginService {
    private static Scanner in = new Scanner(System.in);
    //    记录当前登录的用户
    public static int uid;
    private DBUtils dbUtils = new DBUtils();

    public static void index() {
        int option = in.nextInt();
        if (option == 1) {
            LoginService loginService = new LoginService();
            loginService.login();
        } else if (option == 0) {
            View.bye();
        } else {
            View.exception();
            View.recome();
            index();
        }
    }

    private void login() {
        List<User> userList = dbUtils.getUsersList();
        System.out.println("请输入账号：");
        uid = in.nextInt();
        System.out.println("请输入密码：");
        String password = in.next();
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (uid == user.getId() && password.equals(user.getPassword())) {
                loginSucceed();
                break;
            } else if (i + 1 == userList.size()) {
                View.pwdException();
                loginFailed();
            }
        }
    }

    private void loginSucceed() {
        System.out.println("登录成功!请输入操作序号：");
        OptionController.option();
    }

    private void loginFailed() {
        int option = in.nextInt();
        if (option == 1) {
            login();
        } else if (option == 0) {
            View.bye();
        } else {
            View.exception();
            loginFailed();
        }
    }
}
