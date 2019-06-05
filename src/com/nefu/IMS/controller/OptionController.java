package com.nefu.IMS.controller;

import com.nefu.IMS.service.OptionService;
import com.nefu.IMS.view.View;

import java.util.Scanner;

public class OptionController {
    private static Scanner in = new Scanner(System.in);

    public static void option() {
        OptionService optionService = new OptionService();
        View.choose();
        int optionNum = in.nextInt();
        switch (optionNum) {
            case 1:
                optionService.addBook();
                break;
            case 2:
                optionService.borBook();
                break;
            case 3:
                optionService.retBook();
                break;
            case 4:
                optionService.queryBooks();
                break;
            case 5:
                optionService.history();
                break;
            case 0:
                View.bye();
                break;
            default:
                View.exception();
                option();
        }
    }
}
