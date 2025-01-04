package com.testingacademy.exTestNG;

import org.testng.annotations.Test;

public class TestNG005 {
    @Test(priority = 1)
    public void put1(){
        System.out.println(3);
    }
    @Test(priority = 2)
    public void put2(){
        System.out.println(1);
    }
    @Test(priority = 3)
    public void put3(){
        System.out.println(2);
    }


}
