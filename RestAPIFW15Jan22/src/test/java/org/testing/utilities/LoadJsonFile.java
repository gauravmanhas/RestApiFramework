package org.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class LoadJsonFile {
	
	public static String readJsonFile(String path) throws FileNotFoundException {
		
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		JSONTokener js = new JSONTokener(fis);
		JSONObject bodyData = new JSONObject(js);
		return bodyData.toString();
	}

}
