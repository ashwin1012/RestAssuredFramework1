package RestAssured.PostRequestThroughDifferentMethods.copy;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class pojo_AccessPostRequest {
	@Test(priority = 1)
	public void postStudentsRequest() {
		
		Pojo_PostRequest data=new Pojo_PostRequest();
		
		data.setName("Steve"); 
		data.setLocation("London");
		data.setPhone("83637373637");
		
		String courseArr[]= {"C","C++"};
		data.setCourse(courseArr);
	
	given()
	.contentType("application/json")
	.body(data)
	
	.when()
	.post("http://localhost:3000/students")
	
	.then()
	.statusCode(201)
	.body("name", equalTo("Steve"))
	.body("location", equalTo("London"))
	.body("phone", equalTo("83637373637"))
	.body("course[0]", equalTo("C"))
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
