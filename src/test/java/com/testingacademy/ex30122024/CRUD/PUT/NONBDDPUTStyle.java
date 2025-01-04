package com.testingacademy.ex30122024.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NONBDDPUTStyle {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

    // 664
    // Token -  Token?
    // Payload - {
    //    "firstname" : "jay",
    //    "lastname" : "shankar",
    //    "totalprice" : 1000,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2018-01-01",
    //        "checkout" : "2019-01-01"
    //    },
    //    "additionalneeds" : "Breakfast"
    //}
    // POST - Auth - token
    // POST - Booking ID
    // PUT - token and BookingID

    //    Public void get_token(){
    //
    //    }
    //
    //    public void get_booking_id(){
    //        return bookingid;
    //    }

    @Test
    public void putPositiveTC() {
        String token = "bd18842ac422070";
        String bookingID = "310";

        String payload_put = "{\n" +
                "    \"firstname\" : \"jay\",\n" +
                "    \"lastname\" : \"shankar\",\n" +
                "    \"totalprice\" : 1001,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/" + bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);
        requestSpecification.body(payload_put);

        Response response = requestSpecification.when().put();

        // Get Validatable response to perform validation
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }
}
