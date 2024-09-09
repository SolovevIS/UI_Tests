package ru.api.cucumber.requests;

import io.restassured.response.Response;
import org.junit.Assert;
import ru.api.junit.specs.Specifications;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class Requests {

    public Requests(){

    }

    public  void getRequest(String path){
        Response response =
                given().spec(Specifications.setReqSpec()).when().get("/" + path)
                        .then().spec(Specifications.setRespSpec()).body("data.email", equalTo("janet.weaver@reqres.in")).extract().response();
        response.body().prettyPrint();
        assertEquals("Janet" ,response.jsonPath().getString("data.first_name"));
    }

    public void postRequest(String path){
        String requestBody = """
                {
                    "name": "morpheus",
                    "job": "leader"
                }
                """;
        Response response = given().spec(Specifications.setReqSpec()).body(requestBody).when().post("/" + path);
        Assert.assertNotEquals(response.jsonPath().getString("id"), null);
        response.body().prettyPrint();
    }

    public void putRequest(String path){
        String requestBody = """
                {
                    "name": "morpheus",
                    "job": "zion resident"
                }
                """;
        Response response = given().spec(Specifications.setReqSpec()).body(requestBody).when().put("/" + path).then().spec(Specifications.setRespSpec()).extract().response();
        Assert.assertNotEquals(response.jsonPath().getString("updatedAt"), null);
        response.body().prettyPrint();
    }

    public void deleteRequest(String path){
        given().spec(Specifications.setReqSpec()).when().delete("/" + path).then().statusCode(204);
    }

}
