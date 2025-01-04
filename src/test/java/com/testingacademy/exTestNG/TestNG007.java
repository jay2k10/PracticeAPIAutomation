package com.testingacademy.exTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG007 {
    @Test
    public void serverStartedOk(){
        System.out.println("Server Started!!");
        //Assert.assertTrue(false);
    }
    @Test(dependsOnMethods = "serverStartedOk" )
    public void method1(){
        System.out.println("Method 1");
    }
}
