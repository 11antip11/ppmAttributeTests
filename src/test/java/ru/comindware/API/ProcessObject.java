package ru.comindware.API;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.comindware.API.models.ProcessObjectModel;

import java.util.Map;

import static com.codeborne.selenide.Selenide.sleep;
import static io.restassured.RestAssured.given;
import static ru.comindware.API.Specs.Specs.request;
import static ru.comindware.API.Specs.Specs.responseSpec;

public class ProcessObject {

    public void GetActiveSubtasks(String username, String password, String id) {
        given()
                .spec(request)
                .auth().preemptive().basic(username, password)
                .body(id)
                .when()
                .post("/api/public/system/Process/ProcessObjectService/GetActiveSubtasks")
                .then()
                .log().all()
                .spec(responseSpec);
    }

    @Step("Запустить процесс с параметрами")
    public String CreateWithData(String username, String password, String processAppId, String objectName, Map<String, String> objectData, int syncActivityQuantity) {
        ProcessObjectModel processObjectModel = new ProcessObjectModel(processAppId, objectName, objectData, syncActivityQuantity);
        Response response = given()
                .spec(request)
                .auth().preemptive().basic(username, password)
                .body(processObjectModel)
                .when()
                .post("/api/public/system/Process/ProcessObjectService/Create1")
                .then()
                .log().all()
                .spec(responseSpec).extract().response();
        return response.asString().replaceAll("\\[|\"|\\]|\\s+", "");
    }

    public String GetActiveSubtasksTimer(String username, String password, String id, Integer countRetry) {
        Response response = given()
                .spec(request)
                .auth().preemptive().basic(username, password)
                .body(id)
                .when()
                .post("/api/public/system/Process/ProcessObjectService/GetActiveSubtasks")
                .then()
                .log().all()
                .spec(responseSpec).extract().response();
        String strResponse = response.getBody().asString();
        String expectedStr = "[]";
        if (countRetry == 0) {
            return null;
        }
        if (!strResponse.equals(expectedStr)) {
            return strResponse.replaceAll("\\[|\"|\\]|\\s+", "");
        }
        sleep(4000);
        return GetActiveSubtasksTimer(username, password, id, countRetry - 1);
    }
    public String GetActiveSubprocessesTimer(String username, String password, String id, Integer countRetry) {
        Response response = given()
                .spec(request)
                .auth().preemptive().basic(username, password)
                .body(id)
                .when()
                .post("/api/public/system/Process/ProcessObjectService/GetActiveSubprocesses")
                .then()
                .log().all()
                .spec(responseSpec).extract().response();
        String strResponse = response.getBody().asString();
        String expectedStr = "[]";
        if (countRetry == 0) {
            return null;
        }
        if (!strResponse.equals(expectedStr)) {
            return strResponse.replaceAll("\\[|\"|\\]|\\s+", "");
        }
        sleep(4000);
        return GetActiveSubprocessesTimer(username, password, id, countRetry - 1);
    }
}
