package finalmission.controller;

import static finalmission.TestFixture.memberCreateRequest;
import static finalmission.TestFixture.reservationCreateRequest;
import static finalmission.TestFixture.reservationTimeCreateRequest;
import static finalmission.TestFixture.sportCreateRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class ReservationControllerTest {

    @Test
    void crud_shouldSuccess() {
        RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(memberCreateRequest)
                .when().post("/signup")
                .then().log().all()
                .statusCode(200);

        RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(sportCreateRequest)
                .when().post("/sports")
                .then()
                .statusCode(201);

        RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(reservationTimeCreateRequest)
                .when().post("/times")
                .then()
                .statusCode(201);

        RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(reservationCreateRequest)
                .when().post("/reservations")
                .then()
                .statusCode(201);

        RestAssured.given().log().all()
                .when().get("/reservations")
                .then()
                .statusCode(200);

        RestAssured.given().log().all()
                .when().delete("/reservations/1")
                .then()
                .statusCode(204);
    }
}
