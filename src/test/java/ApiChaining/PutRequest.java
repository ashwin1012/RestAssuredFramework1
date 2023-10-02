package ApiChaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class PutRequest {

	@Test
	void getUser(ITestContext context) {
		
		int id=(int) context.getAttribute("user_id");
		
		Faker faker = new Faker();

		JSONObject data = new JSONObject();

		data.put("name", faker.name().fullName());
		data.put("location", "Netherland");
		data.put("phone", "63553738898");

		String[] courses = {".net", "C++"};
		data.put("courses", courses);
		
        given()
		.contentType("application/json")
		.body(data.toString())
		.pathParam("id", id)
		
		.when()
		.put("http://localhost:3000/students/{id}")
        
        .then()
        .statusCode(200)
        .log().all();
}
}
