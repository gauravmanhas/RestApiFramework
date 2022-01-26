package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC5_DeleteARecord {
	
	@Test
	public void testCase5() throws IOException {
		
		Properties prop = LoadPropertiesFile.readPropertiesFile("../RestAPIFW15Jan22/URI.properties");
		HTTPMethods http = new HTTPMethods(prop);
		Response res = http.deleteARecord("QA_Env_JavaStudents_URI", TC1_PostData.responseIdValue);
		System.out.println("--------TC5--------");
		System.out.println("Response Status code is: "+res.statusCode());
		System.out.println("Response Body data is: >>");
		System.out.println(res.asString());
		
	}

}
