package org.testing.utilities;

import java.util.Random;
import java.util.regex.Pattern;

public class JsonVariableValueReplacement {
	
	public static String assignValueToVariable(String bodyData, String keyName, String keyValue) {
		
		bodyData = bodyData.replaceAll(Pattern.quote("{{"+keyName+"}}"), keyValue);
		return bodyData;
	}

}
