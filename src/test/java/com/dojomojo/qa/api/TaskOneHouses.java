package com.dojomojo.qa.api;

import static io.restassured.RestAssured.given;

import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TaskOneHouses {

	public static void main(String[] args) {

		String uri = "https://www.anapioficeandfire.com/api/houses";

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
		softAssert.assertEquals(jsonPath.getString("name"), "[House Algood, House Allyrion of Godsgrace, House Amber, House Ambrose, House Appleton of Appleton, House Arryn of Gulltown, House Arryn of the Eyrie, House Ashford of Ashford, House Ashwood, House Baelish of Harrenhal]");

		softAssert.assertAll();

		System.out.println(jsonPath.getString("name"));
		System.out.println(jsonPath.getString("name[5]"));
		
	}
}
