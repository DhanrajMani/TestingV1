package RestAssuredTests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPI_PostRequest {
	
	@Test(enabled = false)
	public void createNewUsers() {
		
		//BaseURI
		RestAssured.baseURI= "https://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request parameter along with post request and JSON object
		JSONObject jsonReq = new JSONObject();
		jsonReq.put("name", "Dhanrajmani");
		jsonReq.put("salary", "1000");
		jsonReq.put("age", "29" );
		
		httpRequest.header("Content-Type", "application/json");
		
		//Converting to JSON string
		httpRequest.body(jsonReq.toJSONString());
		
		Response response = httpRequest.request(Method.POST, "/create");
		
		String resbody = response.getBody().asPrettyString();
		System.out.println("Response -- " + resbody);
		
		//status code validation
		int status = response.getStatusCode();
		System.out.println("Statuscode -- " + status);
		Assert.assertEquals(status, 200);
		
		Assert.assertEquals(resbody.contains("Dhanrajmani"), true);
		Assert.assertEquals(resbody.contains("1000"), true);
		Assert.assertEquals(resbody.contains("29"), true);

	}	
	
	@Test(enabled = false)
	public void updateNewUsers() {
		
		given().baseUri("https://reqres.in").auth().none()
		
		.when().get("/api/users")
		
		.then().statusCode(200)
		.body("page", equalTo(1))
		.log().all();
		
	}
	
	@Test
	public void Postusers() {
		
		HashMap<String, String> hp = new HashMap<String, String>();
		hp.put("name", "Dhanu");
		hp.put("job", "QA");
		
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.header("Content-Type", "application/json");		
		httpRequest.body(hp);
		Response response = httpRequest.request(Method.POST, "/api/users");
		
		String s = response.getBody().asString();
		System.out.println(s);
		
		int i = response.getStatusCode();
		System.out.println(i);
		Assert.assertEquals(i, 201);
		Assert.assertEquals(s.contains("Dhanu"), true);
		
		
	}
}
