package jsonValidation;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SecondValidation {

	  @Test
	    public void validateJsonResponse() {
	        // Send a GET request to the API endpoint
	        Response response = given()
	                .contentType(ContentType.JSON)
	                
	                .when()
	                .get(" http://localhost:3000/store");

	        // Assertion: Check content type in response header
	        Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8");
	        
	        // Assertion: Check status code
	        Assert.assertEquals(response.getStatusCode(), 200);

	        // Extract a specific value from JSON response using JSON path
	       String title = response.jsonPath().getString("book[2].title");
	       System.out.println(title);
	       
	        // Assertion: Check the extracted value
	        Assert.assertEquals(title, "Moby Dick");
	    }
}
