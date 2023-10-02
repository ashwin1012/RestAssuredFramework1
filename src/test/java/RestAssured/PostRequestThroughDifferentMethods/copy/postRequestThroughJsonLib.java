package RestAssured.PostRequestThroughDifferentMethods.copy;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.annotations.Test;


public class postRequestThroughJsonLib {

	@Test(priority = 1)
	public void postStudentsJsonLibrary() {
		
		JSONObject data=new JSONObject();
		
		data.put("name", "Steve");
		data.put("location", "London");
		data.put("phone", "83637373637");
		
		String courseArr[]= {".net","C++"};
		data.put("course", courseArr);
	
	given()
	.contentType("application/json")
	.body(data.toString())
	
	.when()
	.post("http://localhost:3000/students")
	
	.then()
	.statusCode(201)
	.body("name", equalTo("Steve"))
	.body("location", equalTo("London"))
	.body("phone", equalTo("83637373637"))
	.body("course[0]", equalTo(".net"))
	.body("course[1]", equalTo("C++"))
	.header("content-Type","application/json; charset=utf-8")
	.log().all();
	}
	
	@Test(priority = 2)
	public void deleteRequest() {
		
		given()
		
		.when()
		.delete("http://localhost:3000/students/4")
		
		.then()
		.statusCode(200);
	}
}
