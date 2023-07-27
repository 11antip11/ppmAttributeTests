package ru.comindware.API;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static ru.comindware.API.Specs.Specs.request;
import static ru.comindware.API.Specs.Specs.responseSpec;

public class AccountService {
    public String GetByAccountName(String username, String password, String accountName) {
        Response response = given()
                .spec(request)
                .auth().preemptive().basic(username, password)
                .body(accountName)
                .when()
                .post("/api/public/system/Base/AccountService/FindByUsername")
                .then()
                .log().all()
                .spec(responseSpec).extract().response();
        return response.asString().replaceAll("\\[|\"|\\]|\\s+", "");
    }
}
