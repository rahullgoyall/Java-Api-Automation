package testcases.api;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import apis.RestGetApi;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.JsonUtils;

public class TestGetRequest {
	
	//@Test
	void getRequestWithoutHeader(){
		
		Response response = RestGetApi.getRequestWithOutHeader("https://reqres.in/api", "/users?page=2");
		String responseBody = response.getBody().asString();
		JSONObject responseJson = new JSONObject(responseBody);
		int statusCode = response.getStatusCode();
	    Assert.assertEquals(JsonUtils.getValueByJPath(responseJson, "/total"), "12");
	    Assert.assertEquals(statusCode, 200);
		
	}
	
	
	//@Test
	void getRequestWithHeader(){
		//headers
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		
		Response response = RestGetApi.getRequestWithHeader("https://reqres.in/api", "/users?page=2",headers);
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
	}
	
	
	//@Test
	void validateResponseHeaders(){
		//headers
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		
		Response response = RestGetApi.getRequestWithHeader("https://reqres.in/api", "/users?page=2",headers);
		
		// response headers
		String ContentType = response.header("Content-Type");
		String Connection	= response.header("Connection");
		System.out.println("Connection:"+Connection);
		System.out.println("Content type:"+ContentType);
	}
	
	
	@Test
	void getAllHeaders(){
		//headers
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		
		Response response = RestGetApi.getRequestWithHeader("https://reqres.in/api", "/users?page=2",headers);
		
		// response headers
		Headers headers1 = response.headers();
		
		for(Header header : headers1){
			System.out.println(header.getName()+":"+header.getValue());
		}
		
	}
	

}
