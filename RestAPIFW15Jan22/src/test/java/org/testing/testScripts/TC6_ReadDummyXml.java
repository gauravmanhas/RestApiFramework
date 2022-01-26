package org.testing.testScripts;

import java.io.IOException;

import org.testing.utilities.LoadXmlData;
import org.testng.annotations.Test;

public class TC6_ReadDummyXml {
	
	@Test
	public void readDummyXml() throws IOException {
		 
		String xmlData = LoadXmlData.readXml("../RestAPIFW15Jan22/src/test/java/org/testing/payloads/dummy.xml");
		System.out.println("-------TC6--------");
		System.out.println(xmlData);
	}

}
