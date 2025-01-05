package com.testingacademy.ex04012025.assersion.gson;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GSONser {
    // Strings
    // Hashmap
    // Class - Pojo -
    // Create class for the Payload - pojo

    // PUT Request
    // token, booking id

//    {
//                "firstname" : "Jim",
//                        "lastname" : "Brown",
//                    "totalprice" : 111,
//                    "depositpaid" : true,
//                    "bookingdates" : {
//                "checkin" : "2018-01-01",
//                        "checkout" : "2019-01-01"
//            },
//                "additionalneeds" : "Breakfast"
//            }

    RequestSpecification r = RestAssured
            .given();

    Response response;

    ValidatableResponse validatableResponse;

    @Description("TC#1 - Verify that create booking is working with valid payload")
    @Test
    public void testNonBDDStylePOSTPositive() {

        Booking booking = new Booking();
        booking.setFirstname("Jay");
        booking.setLastname("Prasad");
        booking.setTotalprice(111);
        booking.setAdditionalneeds("Breakfast");
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2023-01-01");
        bookingDates.setCheckout("2023-01-01");
        booking.setBookingdates(bookingDates);

        Gson gson = new Gson();
        String jsonStringpayload = gson.toJson(booking);
        System.out.println(jsonStringpayload);


        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(jsonStringpayload);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Parse - DeSerilization


    }
}
