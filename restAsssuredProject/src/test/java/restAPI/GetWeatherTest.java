package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetWeatherTest {

	@Test
	public void testResponseCode() {
		
		Response resp=RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?zip=94040,us&appid=b6907d289e10d714a6e88b30761fae22");
	
		int code=resp.getStatusCode();
		
		System.out.println("Status code is "+code);
		
		Assert.assertEquals(code, 200);
	}	
	
	@Test
	public void testBody() {
		
		Response resp=RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?zip=94040,us&appid=b6907d289e10d714a6e88b30761fae22");
	
		String data=resp.asString();
		
		System.out.println("Data is "+data);		
		
		System.out.println("Response time is "+resp.getTime());
	}	
}
