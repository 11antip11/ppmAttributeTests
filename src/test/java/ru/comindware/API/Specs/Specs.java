package ru.comindware.API.Specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.comindware.config.App;

import static io.restassured.RestAssured.with;
import static ru.comindware.helpers.AllureRestAssuredFilter.withCustomTemplates;

public class Specs {
    static String baseUrl = App.config.baseUrl();
    public static RequestSpecification request = with()
            .filter(withCustomTemplates())
            .baseUri(baseUrl)
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}