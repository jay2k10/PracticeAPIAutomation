package com.testingacademy.exTestNG;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG003 {

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify true == true")
    @Test
    public void testCase001(){
        Assert.assertEquals("true","true");
    }
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify true != true")
    @Test
    public void testCase004(){
        Assert.assertEquals("true", false);
    }
}
