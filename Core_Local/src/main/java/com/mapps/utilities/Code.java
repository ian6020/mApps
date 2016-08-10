package com.mapps.utilities;

public enum Code {
	NONE ("code.NONE"),
	MISSING ("code.MISSING"),
	VOILATION ("code.VIOLATION"),
	EXIST ("code.EXIST"),
	VALID ("code.VALID"),
	INVALID ("code.INVALID"),
	SYSTEM_ERROR ("code.SYSTEM_ERROR"),
	NOT_FOUND ("code.NOT_FOUND");
	
	private String key;
	
	private Code(String code) {
		this.key = code;
	}
	
	public String getKey() {
		return key;
	}
	
	public static String getAllKeys() {
		boolean first = true;
		StringBuffer str = new StringBuffer("[");
		for( Code one : Code.values() ) {
			if(first) {
				str.append(one);
				first = false;
			} else str.append(", " + one);
		}
		str.append("]");
		return str.toString();
	}
}
