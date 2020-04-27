package apis;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestDeleteApi {
	
	public static Response deleteRequestWithOutHeader(String uri, String pathParameter){

		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.DELETE,pathParameter);
		return response;

	}

}
