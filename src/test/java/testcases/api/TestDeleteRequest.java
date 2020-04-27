package testcases.api;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import apis.RestDeleteApi;
import apis.RestGetApi;
import io.restassured.response.Response;
import utility.ExtendReportsBase;
import utility.JsonUtils;

public class TestDeleteRequest extends ExtendReportsBase {
	
	@Test
	void getRequestWithoutHeader(){
		logger.set(extent.createTest("getRequestWithoutHeader"));
		
		Response response = RestDeleteApi.deleteRequestWithOutHeader("https://reqres.in/api", "/users/2");
		String responseBody = response.getBody().asString();
		//JSONObject responseJson = new JSONObject(responseBody);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 204);

	}

}
