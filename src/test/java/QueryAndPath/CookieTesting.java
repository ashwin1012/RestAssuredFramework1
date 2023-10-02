package QueryAndPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookieTesting {

	@Test
	public void cookieTesting() {
		
		Response res=given()
		
		.when()
		.get("https://www.google.com/");
		
		
		Map<String, String> cookie_response=res.getCookies();
		System.out.println(cookie_response.keySet());
		
		for(String k:cookie_response.keySet()) {
			String cookie_value=res.getCookie(k);
					System.out.println(k+"            "+cookie_value);
		}
	
	}
}
