package testcases.api;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.dom.DomUtil.NodeProcessor;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import apis.RestGetApi;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import utility.JsonUtils;
import utility.ExtendReportsBase;


public class TestGetRequest extends ExtendReportsBase{
	

	@Test
	void getRequestWithoutHeader(){
		logger = extent.createTest("Get request test") ;
		Response response = RestGetApi.getRequestWithOutHeader("https://reqres.in/api", "/users?page=2");
		String responseBody = response.getBody().asString();
		JSONObject responseJson = new JSONObject(responseBody);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(JsonUtils.getValueByJPath(responseJson, "/total"), "12");
		Assert.assertEquals(statusCode, 200);

	}


	@Test
	void getRequestWithHeader(){
		logger = extent.createTest("Get request test 3") ;
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");

		Response response = RestGetApi.getRequestWithHeader("https://reqres.in/api", "/users?page=2",headers);
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertEquals(8, 200);
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


	//@Test
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
