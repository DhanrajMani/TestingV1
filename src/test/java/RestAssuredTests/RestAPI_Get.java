package RestAssuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPI_Get {

	@Test
	public void getEmployeeDetails() {

		//Specify base URI
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
			
		//Request object	
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET, "/employees");
		
		//Print in console
		String body = response.getBody().asPrettyString();
		System.out.println(body);
		
		//status code validation
		int status = response.statusCode();
		System.out.println("Status code " + status);
		Assert.assertEquals(status, 200);
		
		//status line
		String statusLine = response.statusLine();
		System.out.println("StausLine " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
}
