package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamplesTest {

	@Test
	public void test_Get() {
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
		statusCode(200).
		body("data[2].last_name", equalTo("Funke")).
		body("data.first_name", hasItems("George", "Byron"));
		
		Response resp = RestAssured.get("/users?page=2");
		String str = resp.body().path("data[1].last_name", "");
		System.out.println(str);
	}
	
	@Test
	public void test_Post() {
		
//		Map<String, Object> map = new HashMap<String, Object>();
		
//		map.put("name", "virat");
//		map.put("job", "cricketer");
//		
//		System.out.println(map);
//		
//		JSONObject request = new JSONObject(map);
//		System.out.println(request);
		
		//using another way to do this
		
		JSONObject request = new JSONObject();
		request.put("name1", "virat");
		request.put("job1", "cricketer");
		System.out.println(request);
		
		baseURI = "https://reqres.in/api";
		
		given().
		contentType(ContentType.JSON).//can also use header("Content-Type", "application/json").
		accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
		statusCode(201).log().all();
		
	}
}
