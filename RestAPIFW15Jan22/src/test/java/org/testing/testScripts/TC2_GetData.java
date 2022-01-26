package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC2_GetData {

	@Test
	public void testCase2() throws IOException {

		Properties prop = LoadPropertiesFile.readPropertiesFile("../RestAPIFW15Jan22/URI.properties");
		HTTPMethods http = new HTTPMethods(prop);
		Response res = http.getMethod(TC1_PostData.responseIdValue, "QA_Env_JavaStudents_URI");
		System.out.println("--------TC2--------");
		System.out.println("Response Status code is: "+ res.statusCode());
		System.out.println("--Response Body--");
		System.out.println(res.asString());
	}
}
