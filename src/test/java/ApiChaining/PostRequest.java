package ApiChaining;

import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class PostRequest {
	@Test
	void createUser(ITestContext context) {
		Faker faker = new Faker();

		JSONObject data = new JSONObject();

		data.put("name", faker.name().fullName());
		data.put("location", "USA");
		data.put("phone", "26353853678");

		String[] courses = {"C", "C++"};
		data.put("courses", courses);
		
		Response res = given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students");
		
		int id=res.jsonPath().getInt("id");
		
		System.out.println("Generated Id is  "+id);
		
		context.setAttribute("user_id", id);

	}

}
