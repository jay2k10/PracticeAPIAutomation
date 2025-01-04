package com.testingacademy.exTestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG008 {
    @Parameters("browser")
    @Test
    public void demo(String browser){
        System.out.println("Browser value is:" +browser);
    }
}
