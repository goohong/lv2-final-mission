package finalmission.controller;

import static finalmission.TextFixture.memberCreateRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class AuthControllerTest {

    @Test
    void signup_shouldCreateMember() {

        RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(memberCreateRequest)
                .when().post("/signup")
                .then().log().all()
                .statusCode(200);
    }
}
