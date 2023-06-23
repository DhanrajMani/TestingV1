package RestAssuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPI_Googlemaps_Get {

	@Test
	public void getGooglemapLocation() {
		// baseURI
		RestAssured.baseURI = "https://www.google.com";

		RequestSpecification httpRequest = RestAssured.given();
		// Request method
		Response resp = httpRequest.request(Method.GET,
				"/maps/place/DLF+IT+SEZ+Park+Main+Entrance,+Ramapuram,+Chennai,+Tamil+Nadu+600125/@13.0243875,80.1750469,17z/data=!3m1!4b1!4m5!3m4!1s0x3a5260d062596b79:0xb459d0198ba6832e!8m2!3d13.0243823!4d80.1772356");

		String body = resp.getBody().asPrettyString();
		System.out.println("Response body -- " + body);

		// Headers validation
		String header = resp.header("Content-Type");
		System.out.println("Header --- " + header);
		Assert.assertEquals(header, "text/html; charset=UTF-8");

		String header1 = resp.header("Content-Encoding");
		System.out.println("Header1 --- " + header1);
		Assert.assertEquals(header1, "gzip");

	}

}
