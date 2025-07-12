package com.example.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnApplication {

    public static void main(String[] args) throws ParseException {
        displayDate();
    }

    public static void displayDate() throws ParseException {
     
        ApplicationContext context =
            new ClassPathXmlApplicationContext("date-format.xml");

     
        SimpleDateFormat format =
            context.getBean("dateFormat", SimpleDateFormat.class);
        Date parsed = format.parse("31/12/2018");
        System.out.println("Parsed Date: " + parsed);
    }
}
