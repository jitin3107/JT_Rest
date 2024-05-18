package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutPatchDeleteExamplesTest {

	@Test
	public void test_Put() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "virat");
		request.put("job", "cricketer");
		
		baseURI = "https://reqres.in/api";
		
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
		statusCode(200).
		log().all();
		
	}
	
	
	@Test
	public void test_Patch() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "virat");
		request.put("job", "cricketer");
		
		baseURI = "https://reqres.in";
		
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
		statusCode(200).
		log().all();
		
	}
	
	@Test
	public void test_Delete() {
		
		baseURI = "https://reqres.in";
		
		when().
			delete("/api/users/2").
		then().
		statusCode(204).
		log().all();
		System.out.println("delete cmd");
	}
}
