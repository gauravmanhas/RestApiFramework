package org.testing.testScripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testing.responseValidation.ResponseValidator;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.LoadJsonFile;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC7_PostComplexJson {
	
	@Test
	public static void postComplexJson() throws IOException {
		
		Properties prop = LoadPropertiesFile.readPropertiesFile("../RestAPIFW15Jan22/URI.properties");
		HTTPMethods http = new HTTPMethods(prop);
		String bodyData = LoadJsonFile.readJsonFile
		("../RestAPIFW15Jan22/src/test/java/org/testing/payloads/complexJson.json");
		Response res = http.postMethod(bodyData, "QA_Env_VBStudents_URI");
		System.out.println("--------TC7--------");
		Assert.assertEquals(res.statusCode(), 201);
		ResponseValidator.softValidateStatusCode(201, res);
		ResponseValidator.softValidateResponseData("LOVE LOVE LOVE", res, "store.book[1].title");
		
		ResponseValidator.hardValidateStatusCode(201, res);
		ResponseValidator.hardValidateResponseData("Love and Life", res, "store.book[1].title");
		
		
		
	}

}
