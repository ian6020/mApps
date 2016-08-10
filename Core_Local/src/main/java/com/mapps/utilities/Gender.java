package com.mapps.utilities;

public enum Gender {
	MALE ("gender.MALE"),
	FEMALE ("gender.FEMALE");
	
	private String key;
	
	private Gender(String code) {
		this.key = code.toUpperCase();
	}
	
	public String getKey() {
		return key;
	}
	
	public static String getAllKeys() {
		boolean first = true;
		StringBuffer str = new StringBuffer("[");
		for( Gender one : Gender.values() ) {
			if(first) {
				str.append(one);
				first = false;
			} else str.append(", " + one);
		}
		str.append("]");
		return str.toString();
	}
}
