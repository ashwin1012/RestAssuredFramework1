package RestAssured.PostRequestThroughDifferentMethods.copy;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class postRequestBodyThroughHashMap {

	@Test(priority = 1)
	public void postStudentsRequest() {
		
		HashMap h=new HashMap();
		
		h.put("name", "Steve");
		h.put("location", "London");
		h.put("phone", "83637373637");
		
		String courseArr[]= {".net","C++"};
		h.put("course", courseArr);
	
	given()
	.contentType("application/json")
	.body(h)
	
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
