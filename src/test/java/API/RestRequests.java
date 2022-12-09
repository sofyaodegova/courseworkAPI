package API;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestRequests {
    public static Response getRequest(String baseUri, Map<String, String> params, String link) {

        return given()
                .baseUri(baseUri)
                .params(params)
                .log().uri()
                .contentType(ContentType.JSON)
                .when()
                .get(link)
                .then()
                .log().body()
                .extract()
                .response();
    }
}
