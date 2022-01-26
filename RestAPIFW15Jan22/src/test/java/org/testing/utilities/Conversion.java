package org.testing.utilities;

import org.json.JSONObject;
import org.json.XML;

public class Conversion {
	
	public static String jsonToXml(String XmlData) {

		JSONObject js = XML.toJSONObject(XmlData);
		return js.toString();
	}
	
	public static String xmlToJson(String jsonData) {
		
		JSONObject js = new JSONObject(jsonData);
		String xmlData = XML.toString(js);
		
		return xmlData;
	}

}
