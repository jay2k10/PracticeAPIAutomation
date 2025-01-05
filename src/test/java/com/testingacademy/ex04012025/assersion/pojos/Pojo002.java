package com.testingacademy.ex04012025.assersion.pojos;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pojo002 {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    String bookingId;

    @Test
    public void put_Request_Via_HashMap() {
        // {
        //    "firstname" : "sally",
        //    "lastname" : "brown",
        //    "totalprice" : 111,
        //    "depositpaid" : true,
        //    "bookingdates" : {
        //        "checkin" : "2018-01-01",
        //        "checkout" : "2019-01-01"
        //    },
        //    "additionalneeds" : "Breakfast"
        //}

        // Hashmap ->
        // {} - map

        Map<String, Object> jsonbodyusingmap = new LinkedHashMap<>();
        jsonbodyusingmap.put("firstname", "sally");
        jsonbodyusingmap.put("lastname", "brown");
        jsonbodyusingmap.put("totalprice", 111);
        jsonbodyusingmap.put("depositpaid", true);
        jsonbodyusingmap.put("additionalneeds","Breakfast");

        Map<String,Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        jsonbodyusingmap.put("bookingdates",bookingDatesMap);
        System.out.println(jsonbodyusingmap);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonbodyusingmap).log().all();

        response = requestSpecification.when().post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        bookingId = response.jsonPath().getString("bookingid");
        System.out.println(bookingId);












    }
}
