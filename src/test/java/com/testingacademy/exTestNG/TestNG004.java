package com.testingacademy.exTestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNG004 {
    String token;
    int bookingId;

    @BeforeTest
    public String getToken(){
        token="123";
        return token;
    }
    @BeforeTest
    public void getbookingId(){
        bookingId=123;
    }

    @Test
    public void testPut1(){
        System.out.println(token);
        System.out.println(bookingId);
    }
    @Test
    public void testPut2(){
        System.out.println(token);
        System.out.println(bookingId);
    }


}
