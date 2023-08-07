package ru.comindware.API;

import io.qameta.allure.Step;
import ru.comindware.API.models.ObjectAliasServiceModel;
import ru.comindware.API.models.ObjectIdServiceModel;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static ru.comindware.API.Specs.Specs.request;
import static ru.comindware.API.Specs.Specs.responseSpec;

public class Solution {
    @Step("Удалить тестовые данные")
    public void DeleteByAlias(String username, String password, String alias) {
        given()
                .spec(request)
                .auth().preemptive().basic(username, password)
                .body(alias)
                .when()
                .delete("/webapi/Solution/" + alias)
                .then()
                .log().all()
                .spec(responseSpec).extract().response();
    }
}
