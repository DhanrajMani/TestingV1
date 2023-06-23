package RestAssuredTests;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

public class RestAPI_JsonExternalFile {

	@Test
	public void externalJson() {
		
		File json = new File("./ExternalData.json");
		
		given()
			.baseUri("https://reqres.in")
			.body(json);
		when()
			.post("/users")
			.prettyPrint();
			
	}
}
