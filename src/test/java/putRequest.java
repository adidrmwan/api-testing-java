import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class putRequest {
	
	@Test
	void updateExistingPet() {
		
		RestAssured.baseURI="https://petstore.swagger.io/v2/user";
		
		JSONObject request=new JSONObject();
		request.put("id", 17);
		request.put("username", "adidrmwan");
		request.put("firstName", "adi");
		request.put("lastName", "darmawan");
		request.put("email", "adi@gmail.com");
		request.put("password", "pass123");
		request.put("phone", "089123123");
		request.put("userStatus", 2);
		
		RequestSpecification httpRequest=RestAssured.given();
		Response resp=httpRequest.pathParam("username", "darmawan").body(request.toJSONString()).contentType("application/json").request(Method.PUT,"/{username}");
	
		String ResponseBody=resp.getBody().asString();
		System.out.println(ResponseBody);
		
		//assertion
		int statusCode=resp.getStatusCode();
		String message=resp.getBody().path("message");
		String type=resp.getBody().path("type");

		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(message, "17");
		Assert.assertEquals(type, "unknown");	
	}
}

