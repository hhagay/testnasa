package APITestingNASA.com.nasa.api;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class SearchGetRequests {
	
	String endpoint = RestAssured.baseURI = "https://images-api.nasa.gov/search";
	/*
	 * Simple GET request
	 */
	@Test
	public void Test_ID() {
		Response resp = given().
				param("nasa_id", "PIA12235").
				when().
				get(endpoint);
				System.out.println(resp.getStatusCode());
				Assert.assertEquals(resp.getStatusCode(), 200);
	}
	
	@Test
	public void Test_Q() {
		Response resp = given().
				param("q", "moon").
				when().
				get(endpoint);
		Assert.assertEquals(resp.getStatusCode(), 200);
		
		String reportbyQ = resp.
				then().
				contentType(ContentType.JSON).
				extract().
				path("collection.href");
		System.out.println("Search by q: " + reportbyQ);
//		Assert.assertEquals(baseURI, reportbyQ);
		
		
		
	}


}
