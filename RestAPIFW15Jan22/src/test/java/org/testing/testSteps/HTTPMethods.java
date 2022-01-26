package org.testing.testSteps;

import java.util.Properties;

import org.testing.utilities.LoadPropertiesFile;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class HTTPMethods {

	Properties pr;

	public HTTPMethods(Properties pr) {

		this.pr = pr;
	}

	public Response postMethod(String bodyData, String uriKey) {

		Response res = given().contentType(ContentType.JSON)
		.body(bodyData).when().post(pr.getProperty(uriKey));
		
		return res;
	}

	public Response getMethod(String id, String uriKey) {

		String uri = pr.getProperty(uriKey) + "/" + id;
		Response res = given()
		.contentType(ContentType.JSON).when().get(uri);

		return res;

	}
	
	public Response getAllMethod(String uriKey) {

		Response res = given()
		.contentType(ContentType.JSON).when().get(pr.getProperty(uriKey));
		
		return res;

}
	
	public Response updateRecord(String bodyData, String uriKey, String id) {
		
		String uri = pr.getProperty(uriKey)+"/"+id;
		Response res = given().contentType(ContentType.JSON).body(bodyData).when().put(uri);
		
		return res;
	}
	
	public Response deleteARecord(String uriKey, String id) {
		String uri = pr.getProperty(uriKey)+"/"+id;
		Response res = given().contentType(ContentType.JSON).when().delete(uri);
		
		return res;
	
	}
	
}
