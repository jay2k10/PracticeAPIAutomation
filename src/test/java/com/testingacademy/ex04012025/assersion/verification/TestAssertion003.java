package com.testingacademy.ex04012025.assersion.verification;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAssertion003 {
    @Test
    public void test_verify() {
        String responseName = "Jay";
        Assert.assertEquals("Jay",responseName);

    }
}
