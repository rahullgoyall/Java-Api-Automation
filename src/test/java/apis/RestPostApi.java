package apis;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestPostApi {

	public static Response postRequestWithHeader(String uri, String pathParameter,HashMap<String, String> json,HashMap<String, String> header){
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();

		//Adding json payload
		JSONObject requestJsonPayload = new JSONObject();
		
		for(Map.Entry<String, String> entry : json.entrySet()){
			requestJsonPayload.put(entry.getKey(), entry.getValue());
		}
		
		httpRequest.body(requestJsonPayload.toJSONString());

		//Adding headers
		for(Map.Entry<String, String> entry : header.entrySet()){
			httpRequest.header(entry.getKey(),entry.getValue());
		}

		Response response = httpRequest.request(Method.POST,pathParameter);
		return response;

	}
}
