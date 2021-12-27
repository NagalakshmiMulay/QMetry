package com.qmetry.qaf.example.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class GetStepDef {

    public static RequestSpecification request;
    public static Response response;
    JsonPath js;

    @QAFTestStep(description = "User sets the base URL for Get request")
    public void userSetsTheBaseURLForGetRequest()  {
        RestAssured.baseURI="https://petstore.swagger.io/v2";
        request =RestAssured.given();
        request.contentType(ContentType.JSON);


    }

    @QAFTestStep(description="User perform GET reguest for the user {0}")
    public void userPerformGETReguestForTheUser(String str0){
        response =request.get("/user/nagalakshmi15");
    }

    @QAFTestStep(description="User validates the valid response payload of the user and status code is {0}")
    public void userValidatesTheValidResponsePayloadOfTheUserAndStatusCodeIs(long l0){
        JsonPath js=response.jsonPath();
        System.out.println(js.toString());

        System.out.println("Status code is:  " +
                "" +  response.getStatusCode());

        System.out.println("Got the user details for user : " + response.getBody().path("username"));
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.getBody().path("username"),"nagalakshmi15");

    }

//######################################################################################################################
//Invalid user scenario
    @QAFTestStep(description="User sets the base URL for Get request with invalid user Nagalakshmi{0}")
    public void userSetsTheBaseURLForGetRequestWithInvalidUserNagalakshmi(long l0){
        response =request.get("/user/Nagalakshmi122");
        System.out.println("Status code is :  " +
                "" +  response.getStatusCode() + " " + "for invalid user");

    }




}
