package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestClass {
	
	@Test
	public void test_1() {
		
		System.out.println("Test case 1");
		
		//restassured removed from RestAssured.get after making
		//restassured import as static
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		
		//by doing static import of rest assured
	}

	
	@Test
	public void test_2() {
		
		System.out.println("Test case 2");
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
		statusCode(200).
		body("data[1].id", equalTo(8)).
		body("data[3].email", equalTo("byron.fields@reqres.in")).
		log().all();
	}

}
