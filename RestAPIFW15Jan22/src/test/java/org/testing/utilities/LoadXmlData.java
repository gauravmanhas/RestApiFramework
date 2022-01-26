package org.testing.utilities;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class LoadXmlData {
	
	public static String readXml(String path) throws IOException {
		
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String s;
		String data = "";		
		while ((s = br.readLine()) != null) {
			data = data+s;
		}
		return data;
	}

}
