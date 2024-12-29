package com.testingacademy;

import io.restassured.RestAssured;

public class Test003 {
    public static void main(String[] args) {
        System.out.println("GET all booking");

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(200);
    }
}
