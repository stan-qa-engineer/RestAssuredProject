package restAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUD_Test {

	@Test(priority = 1, groups = { "positive" })
	public void postTest() {

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
	}

	@Test(priority = 2, groups = { "positive" })
	public void deleteTest() {

		RequestSpecification request = RestAssured.given();

		Response response = request.delete("http://localhost:3000/posts/3");

		int code = response.getStatusCode();

		Assert.assertEquals(code, 200);
	}

}
