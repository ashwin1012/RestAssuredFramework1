package jsonValidation;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class FirstApproach {
	@Test
	public void validateJsonResponse() {

		given()
		.contentType(ContentType.JSON)

		.when()
		.get(" http://localhost:3000/store")

		.then()
		.statusCode(200)
		.header("Content-Type","application/json; charset=utf-8")
		.body("book[2].title", equalTo("Moby Dick"))
		.log().all();
	}
}
