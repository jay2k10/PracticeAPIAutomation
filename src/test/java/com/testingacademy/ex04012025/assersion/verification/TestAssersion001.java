package com.testingacademy.ex04012025.assersion.verification;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestAssersion001 {

    //  POST - Create -> Verify the Response
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_post(){
        String payload_POST= "{\n" +
                "    \"firstname\" : \"jay\",\n" +
                "    \"lastname\" : \"shankar\",\n" +
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
        requestSpecification.body(payload_POST).log().all();

        response = requestSpecification.when().post();

        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Rest Assured Default - Hamcrest
        // import org.hamcrest.Matchers;
//        validatableResponse.body("booking.firstname",Matchers.equalTo("jay"));
//        validatableResponse.body("booking.lastname",Matchers.equalTo("shankar"));
//        validatableResponse.body("booking.depositpaid",Matchers.equalTo(false));
//        validatableResponse.body("bookingid",Matchers.notNullValue());



        // TestNG Assertion
        // SoftAssert vs
        // HardAssert - This means that if any assertion fails, the remaining statements in that test method will not be executed.

        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");

//        Assert.assertNotNull(bookingId);
//        Assert.assertEquals(firstname,"Pramod");

        // AssertJ Assertion

        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("jay").isNotEmpty().isNotBlank();
        String s = ""; //Empty
        String s2 = " "; //Blank




//        bookingId = response.jsonPath().getString("bookingid");







    }
}
