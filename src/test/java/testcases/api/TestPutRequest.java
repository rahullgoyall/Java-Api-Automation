package testcases.api;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import apis.RestGetApi;
import apis.RestPutApi;
import io.restassured.response.Response;
import utility.ExtendReportsBase;
import utility.JsonUtils;

public class TestPutRequest extends ExtendReportsBase {
	
	@Test
	void putRequestWithHeader(){
		System.out.println("1");
		logger.set(extent.createTest("putRequestWithHeader"));
		
		//headers
				HashMap<String, String> headers = new HashMap<String, String>();
				headers.put("Content-Type", "application/json");
				
				//json
				HashMap<String, String> json = new HashMap<String, String>();
				json.put("name", "rahul");
				json.put("job", "leader");
				
		Response response = RestPutApi.putRequestWithHeader("https://reqres.in/api", "/users/2",json,headers);
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		JSONObject responseJson = new JSONObject(responseBody);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}


}
