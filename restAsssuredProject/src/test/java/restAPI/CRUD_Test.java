package restAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUD_Test {
	
	@Test(priority = 1, description = "PostMethodPositiveTest", groups = { "positive" })
	public void createTest() {

		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("id", "3");
		json.put("title", "SeleniumTest");
		json.put("author", "Stan");

		request.body(json.toJSONString());

		Response response = request.post("http://localhost:3000/posts");

		int code = response.getStatusCode();

		Assert.assertEquals(code, 201);		
		
		System.out.println("Response time for Post is "+response.getTime());
	}
	
	@Test(priority = 2, description = "GetMethodPositiveTest", groups = { "positive" })
	public void readTest() {

		RequestSpecification request = RestAssured.given();

		Response response = request.get("http://localhost:3000/posts/3");

		int code = response.getStatusCode();

		Assert.assertEquals(code, 200);
		
		System.out.println("Response time for Get is "+response.getTime());		
	}
	
	@Test(priority = 3, description = "PutMethodPositiveTest", groups = { "positive" })
	public void updateTest() {

		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		json.put("id", "3");
		json.put("title", "SeleniumTest");
		json.put("author", "StanUpdated");

		request.body(json.toJSONString());

		Response response = request.put("http://localhost:3000/posts/3");

		int code = response.getStatusCode();

		Assert.assertEquals(code, 200);
		
		System.out.println("Response time for Put is "+response.getTime());
	}

	@Test(priority = 4, description = "DeleteMethodPositiveTest", groups = { "positive" })
	public void deleteTest() {

		RequestSpecification request = RestAssured.given();

		Response response = request.delete("http://localhost:3000/posts/3");

		int code = response.getStatusCode();

		Assert.assertEquals(code, 200);
		
		System.out.println("Response time for Delete is "+response.getTime());
	}
}
