package RestAssuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPI_EmployeeDetails_Get {

	@Test
	public void getJsonBody() {
		
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/employee";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response resp = httpRequest.request(Method.GET, "/1");
		
		//JsonPath for get all JSON body
		JsonPath path = resp.jsonPath();
		System.out.println(path.get("id"));
		System.out.println(path.get("employee_name"));
		System.out.println(path.get("employee_salary"));
		System.out.println(path.get("employee_age"));
		
		Assert.assertEquals(path.get("employee_name"), "Tiger Nixon");
	}
}
