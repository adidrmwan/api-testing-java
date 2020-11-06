import java.io.File;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class school {
	@Test
	
	void nameOfAllStudents() {
		File object = new File("./src/test/java/petData.json"); 
		
		JSONObject name = new JSONObject(object);
	}
}