package ru.api.junit.tests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import ru.api.junit.specs.Specifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.*;

public class Tests {

    @Test
    public void baseRequest(){
        Response response = given().baseUri("https://reqres.in").basePath("/api").when().get("/users/2").then().statusCode(200).extract().response();
        response.body().prettyPrint();
    }

    @Test
    public void singleUserRequest(){
        Response response =
        given().spec(Specifications.setReqSpec()).when().get("/users/2")
                .then().spec(Specifications.setRespSpec()).body("data.email", equalTo("janet.weaver@reqres.in")).extract().response();
        response.body().prettyPrint();
        assertEquals("Janet" ,response.jsonPath().getString("data.first_name"));
    }

    @Test
    public void postRequest(){
        String requestBody = """
                {
                    "name": "morpheus",
                    "job": "leader"
                }
                """;
        Response response = given().spec(Specifications.setReqSpec()).body(requestBody).when().post("/users");
        Assert.assertNotEquals(response.jsonPath().getString("id"), null);
        response.body().prettyPrint();
    }

    @Test
    public void putRequest(){
        String requestBody = """
                {
                    "name": "morpheus",
                    "job": "zion resident"
                }
                """;
        Response response = given().spec(Specifications.setReqSpec()).body(requestBody).when().put("/users/2").then().spec(Specifications.setRespSpec()).extract().response();
        Assert.assertNotEquals(response.jsonPath().getString("updatedAt"), null);
        response.body().prettyPrint();
    }

    @Test
    public void deleteRequest(){
        given().spec(Specifications.setReqSpec()).when().delete("/users/2").then().statusCode(204);
    }
}
