package org.testing.testScripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonVariableValueReplacement;
import org.testing.utilities.LoadJsonFile;
import org.testing.utilities.LoadPropertiesFile;
import org.testing.utilities.RandomData;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC4_UpdateRecordUsingPut {
	
	@Test
	public void testCase4() throws IOException {
		
		String bodyData = LoadJsonFile.readJsonFile
		("../RestAPIFW15Jan22/src/test/java/org/testing/payloads/UpdateJsonData.json");
		
		bodyData = JsonVariableValueReplacement.assignValueToVariable
		(bodyData, "id", TC1_PostData.responseIdValue);
		Properties prop = LoadPropertiesFile.readPropertiesFile("../RestAPIFW15Jan22/URI.properties");		
		HTTPMethods http = new HTTPMethods(prop);
		Response res = http.updateRecord(bodyData, "QA_Env_JavaStudents_URI", TC1_PostData.responseIdValue);
		System.out.println("--------TC4-------");
		System.out.println("Response Status code while updating record : "+res.statusCode());
		res = http.getMethod(TC1_PostData.responseIdValue, "QA_Env_JavaStudents_URI");
		System.out.println("Response Status code while fetching record : "+res.statusCode());
		System.out.println("Response Body Data: >>> ");
		System.out.println(res.asString());
	}

}
