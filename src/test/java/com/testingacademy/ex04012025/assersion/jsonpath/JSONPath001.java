package com.testingacademy.ex04012025.assersion.jsonpath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class JSONPath001 {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;

    @Test
    public void post() {

        String payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON).log().all();
        requestSpecification.body(payload);

        response = requestSpecification.when().post();
//        validatableResponse= response.then();
//        validatableResponse.statusCode(200);

        System.out.println(response.asString());
        JsonPath jsonPath = new JsonPath(response.asString());
        String BookingID = jsonPath.getString("bookingid");
        String FirstName = jsonPath.getString("booking.firstname");
        String LastName = jsonPath.getString("booking.lastname");
        String BookingDate = jsonPath.getString("booking.bookingdates.checkout");
        System.out.println("Booking ID is: " + BookingID);
        System.out.println("First name is: " + FirstName);
        System.out.println("Last name is: " + LastName);
        System.out.println("Booking Date  is: " + BookingDate);


    }
}
