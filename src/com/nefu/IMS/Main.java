package com.nefu.IMS;

import com.nefu.IMS.DataBase.VirData;
import com.nefu.IMS.service.LoginService;
import com.nefu.IMS.view.View;

public class Main {
    public static void main(String[] args) {
//        加载预定义数据
        VirData.user();
        VirData.book();
        VirData.userBook();
//        进入欢迎页
        View.welcome();
        LoginService.index();
    }
}
