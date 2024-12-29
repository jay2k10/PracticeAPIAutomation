package com.testingacademy.ex30122024.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NONBDDStyle {
    static RequestSpecification r = RestAssured.given();

    public static void main(String[] args) {
        r.baseUri("https://api.zippopotam.us");

        testnonbdd1();
        testnonbdd2();
    }

    private static void testnonbdd2() {

        r.basePath("/IN/847308");
        r.when().log().all();
        r.get();
        r.then().log().all().statusCode(200);
    }
    private static void testnonbdd1() {
        r.basePath("/IN/-1");
        r.when().log().all();
        r.get();
        r.then().log().all().statusCode(404);
    }
}
