package finalmission.controller;

import static finalmission.TestFixture.memberCreateRequest;
import static finalmission.TestFixture.reservationTimeCreateRequest;
import static finalmission.TestFixture.testToken;

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
                .body(memberCreateRequest)
                .when().post("/signup")
                .then().log().all()
                .statusCode(200);
        
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

        RestAssured.given().log().all().cookie("token", testToken)
                .when().delete("/times")
                .then()
                .statusCode(204);
    }
}
