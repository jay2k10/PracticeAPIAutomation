package com.testingacademy.ex04012025.assersion.pojos;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Pojo001 {
    public static void main(String[] args) {
        String payload = "{\n" +
                "                    \"username\" : \"admin\",\n" +
                "                    \"password\" : \"password123\"\n" +
                "                }";

        RestAssured.given().baseUri("\"https://restful-booker.herokuapp.com")
                .basePath("/auth").contentType(ContentType.JSON).body(payload)
                .when().log().all()
                .then().statusCode(200);

    }

}
