package finalmission.controller;

import static finalmission.TestFixture.reservationTimeCreateRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class ReservationTimeControllerTest {

    @Test
    void crud_shouldSuccess() {
        RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(reservationTimeCreateRequest)
                .when().post("/times")
                .then()
                .statusCode(201);

        RestAssured.given().log().all()
                .when().get("/times")
                .then()
                .statusCode(200);

        RestAssured.given().log().all()
                .when().delete("/times/1")
                .then()
                .statusCode(204);
    }
}
