package com.testingacademy.exTestNG;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestNG001 {

    @Test
    public void test_get(){
        RestAssured.given().baseUri("https://api.zippopotam.us")
                .basePath("/IN/847308").when().log().all()
                .get().then().log().all()
                .statusCode(200);
    }
}
