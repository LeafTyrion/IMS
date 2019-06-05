package com.nefu.IMS.view;

import com.nefu.IMS.service.OptionService;

import java.util.Scanner;

public class View {
    private static Scanner in = new Scanner(System.in);

    //欢迎页
    public static void welcome() {
        System.out.println("欢迎使用图书管理系统！");
        System.out.println("1. 用户登录");
        System.out.println("0. 退出系统");
        System.out.println("请输入操作序号：");
    }

    //重新登录
    public static void recome() {
        System.out.println("1.用户登录");
        System.out.println("0.退出系统");
    }

    public static void pwdException() {
        System.out.println("用户名或密码错误！");
        recome();
    }

    //登录成功后进行操作选择
    public static void choose() {
        System.out.println("1.新书录入");
        System.out.println("2.借书");
        System.out.println("3.还书");
        System.out.println("4.查询书籍状态");
        System.out.println("5.查询借阅历史");
        System.out.println("0.退出系统");
    }

    //    查询书籍状态
    public static void bookStatus() {
        System.out.println("1.按图书ID查询");
        System.out.println("2.查询全部状态");
        System.out.println("0.返回上一级菜单");
    }

    public static void bookList() {
        System.out.print("图书编号\t\t");
        System.out.print("图书名称\t\t\t");
        System.out.println("可借数量");
    }

    public static void backStatus() {
        System.out.println("0.返回上一级菜单");
        while (true) {
            int option = in.nextInt();
            if (option == 0) {
                OptionService optionService = new OptionService();
                optionService.queryBooks();
                break;
            } else {

                View.exception();
                View.backStatus();
            }
        }
    }

    //    借阅历史查询
    public static void historyView() {
        System.out.println("1.按图书ID查询");
        System.out.println("2.按用户ID查询");
        System.out.println("3.查询全部历史");
        System.out.println("0.返回上一级菜单");
    }

    //    返回上一级菜单
    public static void historyList() {
        System.out.print("用户编号");
        System.out.print("\t\t用户名称");
        System.out.print("\t\t图书编号");
        System.out.print("\t\t图书名称");
        System.out.print("\t\t\t图书状态");
        System.out.print("\t\t\t借书日期");
        System.out.print("\t\t\t\t\t应还日期");
        System.out.println("\t\t\t\t\t实际还书日期");
    }

    public static void backHistory() {
        System.out.println("0.返回上一级菜单");
        while (true) {
            int option = in.nextInt();
            if (option == 0) {
                OptionService optionService = new OptionService();
                optionService.history();
                break;
            } else {

                View.exception();
                View.backHistory();
            }
        }
    }

    //异常提醒
    public static void exception() {
        System.out.println("输入格式错误！请输入正确的操作序号!");
    }

    //结束页面
    public static void bye() {
        System.out.println("谢谢您的使用，再见！");
    }
}
