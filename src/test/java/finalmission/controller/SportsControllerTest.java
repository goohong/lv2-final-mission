package finalmission.controller;

import static finalmission.TestFixture.sportCreateRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class SportsControllerTest {

    @Test
    void crud_shouldSuccess() {
        RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(sportCreateRequest)
                .when().post("/sports")
                .then()
                .statusCode(201);

        RestAssured.given().log().all()
                .when().get("/sports")
                .then()
                .statusCode(200);

        RestAssured.given().log().all()
                .when().delete("/sports/1")
                .then()
                .statusCode(204);
    }
}
