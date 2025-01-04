package com.testingacademy.ex30122024.CRUD.CRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Integrations {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    String bookingID;


    public String get_Token() {
        String payload = "{\n" +
                "                    \"username\" : \"admin\",\n" +
                "                    \"password\" : \"password123\"\n" +
                "                }";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        Response response = r.when().post();

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);

        token = response.jsonPath().getString("token");
        System.out.println("token");

        return token;


    }

    public String get_BookingId() {
        String payload_Post ="{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload_Post).log().all();

        Response response = r.when().post();

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        bookingID = response.jsonPath().getString("bookingId");
        System.out.println(bookingID);
        return bookingID;


    }

    @Test
    public void test_Update_PUT() {

    }

    @Test
    public void test_get() {

    }

    @Test
    public void test_Delete_BookingId() {

    }

    @Test
    public void test_After_Delete_BookingId() {

    }

}
