package org.testing.responseValidation;

import org.testing.utilities.JsonParsingUsingOrgDotJsonAndJsonPath;
import org.testng.Assert;

import io.restassured.response.Response;

public class ResponseValidator {
	
	public static void softValidateStatusCode(int expectedResponseCode, Response res) {
		
		if(expectedResponseCode==res.statusCode()) {
			System.out.println("Status code is matching - expectedResponseCode is: "
			+ expectedResponseCode+ " And actualResponseCode is: "+res.statusCode());
		}
		else {
			//System.out.println("Status code is not matching - expectedResponseCode is: "
			//+ expectedResponseCode+ " And actualResponseCode is: "+ res.statusCode());
			
			System.err.println("Status code is not matching - expectedResponseCode is: "
			+ expectedResponseCode+ " And actualResponseCode is: "+ res.statusCode());
		}
	}
	
public static void hardValidateStatusCode(int expectedResponseCode, Response res) {
		
		Assert.assertEquals(res.statusCode(), expectedResponseCode, "Status code is not matching");
		
	}
	
	public static void softValidateResponseData(String expectedData, Response res, String jsonPath) {
		
		String actualData = JsonParsingUsingOrgDotJsonAndJsonPath.parseJsonUsingJsonPath(res, jsonPath);
		
		if(actualData.equals(expectedData)) {
			System.out.println("Data is matching properly - Actual is = "+ actualData+ " expected is = "+expectedData);
		}
		
		else {
			//System.out.println("Data is not matching properly - Actual is = "+ actualData+ ", but expected is = "+expectedData);
			System.err.println("Data is not matching properly - Actual is = "+ actualData+ ", but expected is = "+expectedData);
		}
	}
	
public static void hardValidateResponseData(String expectedData, Response res, String jsonPath) {
		
		String actualData = JsonParsingUsingOrgDotJsonAndJsonPath.parseJsonUsingJsonPath(res, jsonPath);
		
		Assert.assertEquals(actualData, expectedData, "Data is not matching");
	}

}
