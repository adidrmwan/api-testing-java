import java.io.File;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postRequest {
	
	@Test
	void addNewPet() {
		
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet";
		RequestSpecification httpRequest=RestAssured.given();
		Response resp=httpRequest.body(new File("./src/test/java/petData.json") ).contentType("application/json").request(Method.POST);
	
		String ResponseBody=resp.getBody().asString();
		System.out.println(ResponseBody);
		
		//assertion
		int statusCode=resp.getStatusCode();
		int idPet=resp.getBody().path("id");
		int idCategory=resp.jsonPath().get("category.id");
		int idTags=resp.getBody().path("tags[0].id");
		
		String name=resp.getBody().path("name");
		String categoryName=resp.getBody().path("category.name");
		String tagsName=resp.getBody().path("tags[0].name");
		String photoUrl=resp.getBody().path("photoUrls[0]");
		String status=resp.getBody().path("status");

		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(idPet, 101);
		Assert.assertEquals(idCategory, 201);
		Assert.assertEquals(idTags, 301);
		Assert.assertEquals(name, "fushi");
		Assert.assertEquals(categoryName, "mamalia");
		Assert.assertEquals(tagsName, "cool");
		Assert.assertEquals(photoUrl, "www.pets.com/image-1");
		Assert.assertEquals(status, "available");
		
		
	}
}

