package com.deepeagle.shanty.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class shantyRand {

	
	private static SecureRandom random = new SecureRandom();
	
	
	public static String getRandomString(int length) {
		StringBuilder string = new StringBuilder();
		char tempChar;
		for(int i = 0; i < length; i++){
			tempChar = (char)(random.nextInt(95)+32);
		    string.append(tempChar);
		}
		return string.toString();
	  }
}
