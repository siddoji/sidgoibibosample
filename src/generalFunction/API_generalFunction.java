package generalFunction;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class API_generalFunction {
	
	public static int res_statusCode(String baseURI,String resource) {
		
		RestAssured.baseURI=baseURI;
		
		int statusCode=given().header("Content-Type","application/json").when().get(resource).then().extract().statusCode();
		return statusCode;
				
	}
	
	public static String res_responseBody(String baseURI,String resource) {
		 
		RestAssured.baseURI=baseURI;
		
		String responseBody=given().header("Content-Type","application/json").when().get(resource).then().extract().response().asString();
		return responseBody;
	}

}
