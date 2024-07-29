package org.acme;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CxfClientRestTest {
    @Test
    void testHelloEndpoint() {
        given()
                .when().get("http://localhost:8080/cxf/calculator-client/add?a=2&b=1")
                .then()
                .statusCode(200)
                .body(is("3"));
    }

    @Test
    void testMultiply() {
        given()
                .when().get("http://localhost:8080/cxf/calculator-client/multiply?a=2&b=7")
                .then()
                .statusCode(200)
                .body(is("14"));
    }

    @Test
    void testDivide() {
        given()
                .when().get("http://localhost:8080/cxf/calculator-client/divide?a=6&b=2")
                .then()
                .statusCode(200)
                .body(is("3"));
    }

    @Test
    void testSubtract() {
        given()
                .when().get("http://localhost:8080/cxf/calculator-client/subtract?a=6&b=2")
                .then()
                .statusCode(200)
                .body(is("4"));
    }

}
