package org.testing.utilities;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.response.Response;

public class JsonParsingUsingOrgDotJsonAndJsonPath {
	
	public static String parseJson(String response, String keyName) {
		
		JSONObject obj = new JSONObject(response);
		
		return obj.get(keyName).toString();
		
	}
	
public static ArrayList<String> parseJsonAllKeys(String response, String keyName) {
		ArrayList<String> al = new ArrayList<String>(); 
		JSONArray arr = new JSONArray(response);
		
		for (int i = 0; i < arr.length(); i++) {
			
			JSONObject obj = arr.getJSONObject(i);
			System.out.println("Object index is: "+ i + " Key is: "+keyName
			+ " And Value is: "+obj.getString(keyName));
			al.add(obj.getString(keyName));
		}
		return al;
		
	}

public static String parseJsonUsingJsonPath(Response res, String jsonPath) {
	
	return res.jsonPath().get(jsonPath);
}

}
