package org.testing.testScripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingOrgDotJsonAndJsonPath;
import org.testing.utilities.LoadPropertiesFile;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC3_GetAll {
	
	@Test
	public void testCase3() throws IOException {
		
		Properties prop = LoadPropertiesFile.readPropertiesFile("../RestAPIFW15Jan22/URI.properties");
		HTTPMethods http = new HTTPMethods(prop);
		Response res = http.getAllMethod("QA_Env_JavaStudents_URI");
		System.out.println("-------TC3-------");
		System.out.println("Response Status code is: "+res.statusCode());
		System.out.println("--Response Body is: ");
		System.out.println(res.asString());
		//JsonParsingUsingOrgDotJson.parseJsonAllKeys(res.asString(), "id");
		ArrayList<String> al = JsonParsingUsingOrgDotJsonAndJsonPath.parseJsonAllKeys(res.asString(), "id");
		
		System.out.println("------------------Printing ArrayList----------------");
		System.out.println(al);
		
	}

}
