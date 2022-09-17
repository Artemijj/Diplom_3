import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserActivities {
    String token;
    String json;

    @Step
    public ValidatableResponse create(String userEmail, String userPassword, String userName) {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        json = "{\"email\": \"" + userEmail + "\", \"password\": \"" + userPassword + "\", \"name\": \"" + userName + "\"}";
        ValidatableResponse responseCreate =
                given()
                        .header("Content-type", "application/json")
                        .body(json)
                        .when()
                        .post("/api/auth/register")
                        .then();
        return responseCreate;
    }

    @Step
    public void delete(String userEmail, String userPassword) throws NullPointerException {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        json = "{\"email\": \"" + userEmail + "\", \"password\": \"" + userPassword + "\"}";
        try {
            token =
                    given()
                            .header("Content-type", "application/json")
                            .body(json)
                            .post("/api/auth/login")
                            .then()
                            .extract()
                            .path("accessToken");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if (token != null) {
            given()
                    .header("Content-type", "application/json")
                    .auth().oauth2(token.substring(7))
                    .delete("/api/auth/user")
                    .then();
        }
    }
}
