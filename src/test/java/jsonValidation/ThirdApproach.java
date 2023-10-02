package jsonValidation;

import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ThirdApproach {

	@Test
	public void validateJsonResponse() {
		// Send a GET request to the API endpoint
		Response res = given()
				.contentType(ContentType.JSON)

				.when()
				.get(" http://localhost:3000/store");
		

		
		  Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");

		  Assert.assertEquals(res.getStatusCode(), 200);
		  
		  JSONObject jo = new JSONObject(res.getBody().asString());

		  boolean status=false;
		  
		  for(int i=0;i<jo.getJSONArray("book").length();i++) {
			  String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			  
			  if(bookTitle.equals("Moby Dick")) {
				  status=true;
				  break;
			  }
		  }
		  Assert.assertEquals(status, true);
	}
}
