package ru.comindware.API;

import io.restassured.response.Response;
import ru.comindware.API.models.UserTaskModel;

import static io.restassured.RestAssured.given;
import static ru.comindware.API.Specs.Specs.request;
import static ru.comindware.API.Specs.Specs.responseSpec;

public class UserTask {
    public void CompleteTask(String username, String password, String taskId, boolean completeSubtasks) {
        UserTaskModel userTaskModel = new UserTaskModel(taskId, completeSubtasks);
        given()
                .spec(request)
                .auth().preemptive().basic(username, password)
                .body(userTaskModel)
                .when()
                .post("/api/public/system/TeamNetwork/UserTaskService/Complete")
                .then()
                .log().all()
                .spec(responseSpec).extract().response();
    }
    public String GetBusinessObject(String username, String password, String taskId) {
        Response response = given()
                .spec(request)
                .auth().preemptive().basic(username, password)
                .body(taskId)
                .when()
                .post("/api/public/system/TeamNetwork/UserTaskService/GetBusinessObject")
                .then()
                .log().all()
                .spec(responseSpec).extract().response();
        return response.asString().replaceAll("\\[|\"|\\]|\\s+", "");
    }
}
