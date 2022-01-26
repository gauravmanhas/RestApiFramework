package org.testing.utilities;

import java.util.Random;

public class RandomData {
	
	public static String generateRandomNumber() {
		Random r = new Random();
		Integer val = r.nextInt();
		
		return val.toString();
	}

}
