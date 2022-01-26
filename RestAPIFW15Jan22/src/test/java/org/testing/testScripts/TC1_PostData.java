 package org.testing.testScripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingOrgDotJsonAndJsonPath;
import org.testing.utilities.JsonVariableValueReplacement;
import org.testing.utilities.LoadJsonFile;
import org.testing.utilities.LoadPropertiesFile;
import org.testing.utilities.RandomData;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC1_PostData {
	
	static String responseIdValue;

	@Test
	public void testCase1() throws IOException {
		String bodyData = LoadJsonFile.readJsonFile("../RestAPIFW15Jan22/src/test/java/org/testing/payloads/JsonBodyData.json");
		String randomId = RandomData.generateRandomNumber();
		bodyData = JsonVariableValueReplacement.assignValueToVariable(bodyData, "id", randomId);
		Properties prop = LoadPropertiesFile.readPropertiesFile("../RestAPIFW15Jan22/URI.properties");
		HTTPMethods http = new HTTPMethods(prop);
		Response res = http.postMethod(bodyData, "QA_Env_JavaStudents_URI");
		
		//below 2 lines from sanket
		//System.out.println("----------------ID Value is -----------------");
		//System.out.println(res.jsonPath().get("id").toString());
		
		
		System.out.println("--------TC1-------");
		System.out.println("Status code is " + res.statusCode());
		System.out.println("--Respose Body is--");
		System.out.println(res.asString());
		responseIdValue = JsonParsingUsingOrgDotJsonAndJsonPath.parseJson(res.asString(), "id");
	}
}
