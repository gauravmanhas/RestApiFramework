package org.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//purpose of this class is to load/read URI.properties file

public class LoadPropertiesFile {
	
	public static Properties readPropertiesFile(String path) throws IOException {
		
		//we made this static so that we can call this method with class name without creating the obj
		//usually we create utilities as static
		
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fis);
		return prop;
		
		
	}

}
