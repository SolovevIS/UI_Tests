package ru.api.junit.specs;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.api.junit.utils.Utils;

public class Specifications {

    public static RequestSpecification setReqSpec(){
        RequestSpecification recSpec = RestAssured.given().baseUri(Utils.readProperties().getProperty("baseUrl")).basePath("/api");
        return recSpec;
    }

    public static ResponseSpecification setRespSpec(){
        ResponseSpecification respSpec = RestAssured.expect().statusCode(200).contentType("application/json");
        return respSpec;
    }

    public static ResponseSpecification setPostRespSpec(){
        ResponseSpecification postRespSpec = RestAssured.expect().statusCode(201).contentType("application/json");
        return postRespSpec;
    }
}
