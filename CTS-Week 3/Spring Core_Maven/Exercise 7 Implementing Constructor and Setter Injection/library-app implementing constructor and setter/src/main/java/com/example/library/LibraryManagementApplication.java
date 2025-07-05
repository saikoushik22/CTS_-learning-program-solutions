// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.library;

import com.example.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public LibraryManagementApplication() {
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService service = (BookService) ctx.getBean(BookService.class);
        System.out.println("Primary repo  : " + String.valueOf(service.listPrimaryBooks()));
        System.out.println("Secondary repo: " + String.valueOf(service.listSecondaryBooks()));
    }
}
