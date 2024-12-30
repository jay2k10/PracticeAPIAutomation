package com.testingacademy.ex30122024.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NONBDDPost {
    public static void main(String[] args) {


        // POST Request
        // URL - https://restful-booker.herokuapp.com/auth
        // BODY - PAYLOAD - JSON
        // {
        //    "username" : "admin",
        //    "password" : "password123"
        //}
        // HEADER - Content Type -> application/json

        String payload = "{\n" +
                "                    \"username\" : \"admin\",\n" +
                "                    \"password\" : \"password123\"\n" +
                "                }";
        // given - Request specification
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth").contentType(ContentType.JSON).log().all();
        r.body(payload);

        // when - response
        Response response= r.when().post();

        // then - validate Response
        //validation

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }
}
