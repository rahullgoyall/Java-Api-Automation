package apis;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestGetApi {

	public static Response getRequestWithOutHeader(String uri, String pathParameter){

		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,pathParameter);
		return response;

	}

	public static Response getRequestWithHeader(String uri, String pathParameter,HashMap<String, String> header){
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		
		//Adding headers
		for(Map.Entry<String, String> entry : header.entrySet()){
		httpRequest.header(entry.getKey(),entry.getValue());
		}
		
		Response response = httpRequest.request(Method.GET,pathParameter);
		return response;

	}
}
