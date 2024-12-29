package com.testingacademy;

import io.restassured.RestAssured;

public class Test002 {
    public static void main(String[] args) {
        System.out.println("RestAssured Test case");
        System.out.println(" GET Request Demo");


//        given() - url,body,payload,headers
//        when() - http methods like GET, PUT, POST, PATCH, DELETE
//        then() - verify the response like ER == AR
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking/1").log().all()
                .when()
                .get()
                .then().log().all()
                .statusCode(200);
    }
}
