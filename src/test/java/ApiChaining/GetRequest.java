package ApiChaining;

import static io.restassured.RestAssured.given;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetRequest {

	@Test
	void getUser(ITestContext context) {
		
		int id=(int) context.getAttribute("user_id");
		
		        given()
				.contentType("application/json")
				.pathParam("id", id)
				
				.when()
				.get("http://localhost:3000/students/{id}")
		        
		        .then()
		        .statusCode(200)
		        .log().all();
	}
}
