package com.testingacademy.ex30122024.CRUD.CRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Integrations {
    //  Create a Token
    // Create a Booking
    //  Perform  a PUT request
    //  Verify that PUT is success by GET Request
    // Delete the ID
    // Verify it doesn't exist GET Request
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token_given;
    String bookingID;


    public String get_Token() {
        String payload = "{\n" +
                "                    \"username\" : \"admin\",\n" +
                "                    \"password\" : \"password123\"\n" +
                "                }";

        // Given - Request Spec
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        // When -     Response
        Response response = r.when().post();

        // Then - ValidatableResponse
        // Validation
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        // Extract the token
        token_given = response.jsonPath().getString("token");
        System.out.println("Value of token is :" + token_given);
        return token_given;
    }

    public String get_BookingId() {
        String payload_Post = "{\n" +
                "    \"firstname\" : \"jaya\",\n" +
                "    \"lastname\" : \"Shankar\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_Post).log().all();

        response = requestSpecification.when().post();

        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        bookingID = response.jsonPath().getString("bookingid");
        System.out.println("Value of booking id is " + bookingID);
        return bookingID;


    }

    @Test(priority = 1)
    public void test_Update_PUT() {
        token_given = get_Token();
        bookingID = get_BookingId();
        String payloadPUT = "{\n" +
                "    \"firstname\" : \"Shankar\",\n" +
                "    \"lastname\" : \"Jaya\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" + bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token_given);
        requestSpecification.body(payloadPUT).log().all();

        response = requestSpecification.when().put();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


    }


    @Test(priority = 2)
    public void test_Delete_BookingId() {
        token_given = get_Token();
        bookingID = get_BookingId();
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" + bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token_given);
        //requestSpecification.body(payloadPUT).log().all();

        response = requestSpecification.when().delete();


        // Get Validate response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);


    }

    @Test(priority = 3)
    public void test_After_Delete_BookingId() {
        token_given = get_Token();
        bookingID = get_BookingId();
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" + bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token_given);
        //requestSpecification.body(payloadPUT).log().all();

        response = requestSpecification.when().post();


        // Get Validate response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(404);

    }

}


