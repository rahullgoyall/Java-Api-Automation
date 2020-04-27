package testcases.api;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import apis.RestGetApi;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import utility.ExtendReportsBase;
import utility.JsonUtils;


public class TestGetRequest extends ExtendReportsBase{
	

	@Test(groups = {"demo"})
	void getRequestWithoutHeader(){
		System.out.println("1");
		logger.set(extent.createTest("getRequestWithoutHeader"));
		Response response = RestGetApi.getRequestWithOutHeader("https://reqres.in/api", "/users?page=2");
		String responseBody = response.getBody().asString();
		JSONObject responseJson = new JSONObject(responseBody);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(JsonUtils.getValueByJPath(responseJson, "/total"), "12");
		Assert.assertEquals(statusCode, 200);

	}


	@Test(groups = {"demo"})
	void getRequestWithHeader(){
		System.out.println("2");
		logger.set(extent.createTest("getRequestWithHeader"));
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");

		Response response = RestGetApi.getRequestWithHeader("https://reqres.in/api", "/users?page=2",headers);
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertEquals(8, 200);
	}


	@Test(dataProvider="testdata")
	void validateResponseHeaders(String var1, String var2){
		logger.set(extent.createTest("validateResponseHeaders"));
		//headers
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");

		Response response = RestGetApi.getRequestWithHeader("https://reqres.in/api", "/users?page=2",headers);

		// response headers
		String ContentType = response.header("Content-Type");
		String Connection	= response.header("Connection");
		System.out.println("Connection:"+Connection);
		System.out.println("Content type:"+ContentType);
		System.out.println(var1+var2);
	}


	@Test
	void getAllHeaders(){
		logger.set(extent.createTest("getAllHeaders"));
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
	
	@DataProvider(name="testdata")
	public static Object[][] dataInfo(){
		return new Object[][] {{"hello","hello"},{"bye","bye"}};
	}	


}
