package ru.comindware.API;

import io.qameta.allure.Step;
import ru.comindware.API.models.ObjectAliasServiceModel;
import ru.comindware.API.models.ObjectIdServiceModel;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static ru.comindware.API.Specs.Specs.request;
import static ru.comindware.API.Specs.Specs.responseSpec;

public class ObjectService {
    public void EditObjectById(String username, String password, String objectId, Map<String, String> objectData) {
        ObjectIdServiceModel objectIdSServiceModel = new ObjectIdServiceModel(objectId,objectData);
        given()
                .spec(request)
                .auth().preemptive().basic(username, password)
                .body(objectIdSServiceModel)
                .when()
                .post("/api/public/system/TeamNetwork/ObjectService/Edit")
                .then()
                .log().all()
                .spec(responseSpec).extract().response();
    }
    public void CreateWithObjectAlias(String username, String password, String objectAlias, Map<String, String> objectData) {
        ObjectAliasServiceModel objectAliasServiceModel = new ObjectAliasServiceModel(objectAlias,objectData);
        given()
                .spec(request)
                .auth().preemptive().basic(username, password)
                .body(objectAliasServiceModel)
                .when()
                .post("/api/public/system/TeamNetwork/ObjectService/CreateWithAlias")
                .then()
                .log().all()
                .spec(responseSpec).extract().response();
    }
    @Step("Удалить тестовые данные")
    public void DeleteObjectById(String username, String password, String objectId) {
        given()
                .spec(request)
                .auth().preemptive().basic(username, password)
                .body(objectId)
                .when()
                .post("/api/public/system/TeamNetwork/ObjectService/Delete")
                .then()
                .log().all()
                .spec(responseSpec).extract().response();
    }
}
