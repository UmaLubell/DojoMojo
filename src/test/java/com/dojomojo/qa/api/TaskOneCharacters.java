package com.dojomojo.qa.api;

import static io.restassured.RestAssured.given;

import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TaskOneCharacters {

	public static void main(String[] args) {

		String uri = "https://www.anapioficeandfire.com/api/characters";

		// Create Response object
		Response response;

		// Sending get request and storing the Server response to response object
		response = given()

				.when().get(uri)

				.then().extract().response();

		// PrettyPrint() just prints the response in json format
		response.prettyPrint();

		// get the status code
		System.out.println("Status Code: " + response.getStatusCode());
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(200, response.getStatusCode());

		// create a jsonPath obj
		JsonPath jsonPath = response.jsonPath();

		// validation
		softAssert.assertEquals(jsonPath.getString("aliases"), "[[The Daughter of the Dusk], [Hodor], [Lamprey], [The Merling Queen], [Old Crackbones], [The Poetess], [Porridge], [Quickfinger], [the Sailor's Wife], [The Veiled Lady]]");
        softAssert.assertTrue(jsonPath.getString("culture").contains("Braavosi"));

		softAssert.assertAll();

		System.out.println(jsonPath.getString("aliases"));
		System.out.println(jsonPath.getString("culture[0]"));
		
	}
}
