package ApiChaining;

import static io.restassured.RestAssured.given;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteRequest {

	@Test
	void deleteUser(ITestContext context) {
		
		int id=(int) context.getAttribute("user_id");
		
        given()
		.contentType("application/json")
		.pathParam("id", id)
		
		.when()
		.delete("http://localhost:3000/students/{id}")
        
        .then()
        .statusCode(200)
        .log().all();
}
}
