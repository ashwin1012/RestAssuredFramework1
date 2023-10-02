package RestAssured.PostRequestThroughDifferentMethods.copy;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


public class External_JsonFile {
	
	@Test(priority = 1)
	void PostRequest() throws FileNotFoundException {
		
		 File f = new File("./Body.json");
		 
         FileInputStream fis = new FileInputStream(f);
         
         InputStreamReader isr = new InputStreamReader(fis);
         
         JSONTokener jt = new JSONTokener(isr);
         
         JSONObject data = new JSONObject(jt);
	
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
