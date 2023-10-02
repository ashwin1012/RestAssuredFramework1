package QueryAndPath;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameters {
	
	//https://reqres.in/api/users?page=2&id=5
	
	@Test
	public void testQueryAndPathParameters() {
		
	given()
	.pathParam("mypath", "users")//Path Parameters
	.queryParam("page", "2")//Query Parameters
	.queryParam("id", "5")//Query Parameters
	
	.when()
	//Query Parameters need not to be written in the url
	.get("https://reqres.in/api/{mypath}")  
	
	.then()
	.statusCode(200)
	.log().all();
	}

}
