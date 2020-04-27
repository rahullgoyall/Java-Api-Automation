package testcases.api;

import java.util.HashMap;

import org.testng.annotations.Test;
import apis.RestPostApi;
import io.restassured.response.Response;

public class TestPostRequest {
	
	@Test
	void postRequestWithHeader(){
		//headers
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		
		//json
		HashMap<String, String> json = new HashMap<String, String>();
		json.put("name", "rahul");
		json.put("job", "leader");
		
		Response response = RestPostApi.postRequestWithHeader("https://reqres.in/api", "/users", json, headers);
		String responseBody = response.getBody().asString();
		int statusCode = response.getStatusCode();
	    
		System.out.println(statusCode);
		System.out.println(responseBody);
	}

}
