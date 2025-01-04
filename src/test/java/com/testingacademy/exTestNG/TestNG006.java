package com.testingacademy.exTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG006 {
    @Test(groups = {"sanity","qa"})
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
    }
    @Test(groups = {"qa"})
    public void regRun(){
        System.out.println("Reg");
    }
    @Test(groups = {"sanity","smoke","qa"})
    public void smokeRun(){
        System.out.println("Smoke");
        //Assert.assertEquals(true,true); //Both are same
        Assert.assertTrue(false);
    }
}
