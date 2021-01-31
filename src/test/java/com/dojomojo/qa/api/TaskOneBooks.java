package com.dojomojo.qa.api;

import static io.restassured.RestAssured.given;

import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TaskOneBooks {

	public static void main(String[] args) {

		String uri = "https://www.anapioficeandfire.com/api/books";

		// Create Response object
		Response response;

		// Sending get request and storing the Server response to response object
		response = given()

				.when()
					.get(uri)
					
				.then()
					.extract()
					.response();

		// PrettyPrint() just prints the response in json format
		response.prettyPrint();

		// get the status code
		SoftAssert softAssert = new SoftAssert();	
		softAssert.assertEquals(200, response.getStatusCode());
		System.out.println("Status Code: "+ response.getStatusCode());
		
		//create a jsonPath obj 
		JsonPath jsonPath = response.jsonPath();
		
		//validation
		softAssert.assertEquals(jsonPath.getString("name"), "[A Game of Thrones, A Clash of Kings, A Storm of Swords, The Hedge Knight, A Feast for Crows, The Sworn Sword, The Mystery Knight, A Dance with Dragons, The Princess and the Queen, The Rogue Prince]");
		softAssert.assertEquals(jsonPath.getString("name[3]"), "The Hedge Knight");
		softAssert.assertTrue(jsonPath.getString("authors").contains("George R. R. Martin"));
		
		softAssert.assertAll();
		
		System.out.println(jsonPath.getString("name"));
		System.out.println(jsonPath.getString("name[3]"));
		System.out.println(jsonPath.getString("authors"));
	}
}
