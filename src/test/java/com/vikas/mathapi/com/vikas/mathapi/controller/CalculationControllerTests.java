package com.vikas.mathapi.com.vikas.mathapi.controller;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CalculationControllerTests {

    @Test
    public void calculatorAddTest() {
        baseURI = "http://localhost:8082/math";
        given().get("/add/{operands}", "1,2,3,4").then().statusCode(200).body("result", equalTo("10.0"));
    }

    @Test
    public void calculatorSubTest() {
        baseURI = "http://localhost:8082/math";
        given().get("/sub/{operands}", "1,2,3,4").then().statusCode(200).body("result", equalTo("-8.0"));
    }

    @Test
    public void calculatorMulTest() {
        baseURI = "http://localhost:8082/math";
        given().get("/mul/{operands}", "1,2,3,4").then().statusCode(200).body("result", equalTo("24.0"));
    }

    @Test
    public void calculatorDivTest() {
        baseURI = "http://localhost:8082/math";
        given().get("/div/{operands}", "1,2").then().statusCode(200).body("result", equalTo("0.5"));
    }
}
