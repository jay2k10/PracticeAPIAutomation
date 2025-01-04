package com.testingacademy.exTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG009 {
    @Test
    public void test1(){
        System.out.println();
        Assert.assertTrue(true);

    }
    @Test(enabled = false)
    public void test2(){
        System.out.println();
        Assert.assertTrue(false);

    }
    @Test(alwaysRun = true)
    public void test3(){
        System.out.println();
        Assert.assertTrue(false );

    }
}
