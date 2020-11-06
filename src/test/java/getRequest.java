import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getRequest {
	
	@Test
	void getPetByStatuDetail() {
		
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet/findByStatus";
		RequestSpecification httpRequest=RestAssured.given();
		Response resp=httpRequest.queryParam("status", "sold").contentType("application/json").request(Method.GET);
	
		String ResponseBody=resp.getBody().asString();
		System.out.println(ResponseBody);
		
		//assertion
		int statusCode=resp.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		
	}
}

