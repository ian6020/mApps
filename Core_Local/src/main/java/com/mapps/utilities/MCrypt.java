package com.mapps.utilities;

import com.lambdaworks.crypto.SCryptUtil;

public class MCrypt {

	public static String crypt(String password) {
		String crypt = null;
		if(password != null && !password.trim().isEmpty())
			crypt = SCryptUtil.scrypt(password, 128, 16, 16);
		
		return crypt;
	}
	
	public static boolean check(String password, String hashed) {
		boolean isEqual = false;
		if(password != null && !password.trim().isEmpty() &&
				hashed != null && !hashed.trim().isEmpty())
			isEqual = SCryptUtil.check(password, hashed);
		
		return isEqual;
	}
}
