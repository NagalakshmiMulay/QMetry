package com.qmetry.qaf.example.steps.apis;

import Data.imp.UserData;
import com.qmetry.qaf.automation.step.QAFTestStep;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class CreateUserDef {
     public static RequestSpecification request;
    public static Response response;

    @QAFTestStep(description="User sets the base URL")
    public void userSetsTheBaseURL(){
        RestAssured.baseURI="https://petstore.swagger.io/v2";
        request =RestAssured.given();
        request.contentType(ContentType.JSON);
    }

    @QAFTestStep(description="User sets the Request Payload {0},{1},{2},{3},{4},{5},{6},{7}")
    public void userSetsTheRequestPayload(String id,String username,String firstName,String lastName,String email,String password,String phone,String userStatus){
        int id1=Integer.parseInt(id);
        int userStatus1=Integer.parseInt(userStatus);


        UserData userData=new UserData(id1,username,firstName,lastName,email,password,phone,userStatus1);

        request.body(userData);
        response =request.post("/user");

    }

    @QAFTestStep(description="User validates the valid response payload for list of users and status code is {0}")
    public void userValidatesTheValidResponsePayloadForListOfUsersAndStatusCodeIs(long l0){

        JsonPath js=response.jsonPath();
        System.out.println(js.toString());
        System.out.println("Sattus Code is : " + response.getStatusCode());
        String payloadId=response.getBody().path("message");
        System.out.println("Created Payload with id : "+ payloadId );

        Assert.assertEquals(payloadId,"111");
        Assert.assertEquals(response.getStatusCode(),200);
   }


    @QAFTestStep(description="User validates the valid response payload for list of users {0} and status code is {1}")
    public void userValidatesTheValidResponsePayloadForListOfUsersAndStatusCodeIs(String userId,long statusCode){

        JsonPath js=response.jsonPath();
        System.out.println(js.toString());
        System.out.println("Sattus Code is : " + response.getStatusCode());
        String payloadId=response.getBody().path("message");
        System.out.println("Created Payload with id : "+ payloadId );

        Assert.assertEquals(payloadId,userId);
        Assert.assertEquals(response.getStatusCode(),statusCode);

    }

}
