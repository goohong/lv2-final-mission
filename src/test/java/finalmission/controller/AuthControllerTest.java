package finalmission.controller;

import static finalmission.TestFixture.memberCreateRequest;
import static org.hamcrest.Matchers.notNullValue;

import finalmission.dto.request.MemberCreateRequest;
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

    @Test
    void signup_shouldCreateMemberWithRandomName_IfNameIsNullInRequest() {
        RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(new MemberCreateRequest(
                        null,
                        memberCreateRequest.email(),
                        memberCreateRequest.name(),
                        memberCreateRequest.role()))
                .when().post("/signup")
                .then().log().all()
                .statusCode(200)
                .body("name", notNullValue());
    }
}
