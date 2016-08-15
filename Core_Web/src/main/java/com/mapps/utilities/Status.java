package com.mapps.utilities;

public enum Status {
	NONE ("Server NONE"),
	OK ("Server OK"),
	UNKNOWN ("Server UNKNOWN ERROR"),
	ERROR ("Server ERROR"),
	FRAUD ("Server FRAUD"),
	FAILED ("Server FAILED"),
	SUCCESS ("Server SUCCESS"),
	AUTH_FAIL ("Authentication FAILED"),
	OPERATION_ERR ("Server NOT AUTHORIZE OPERATION"),
	CREATION ("Server CREATION");
	
	private String key;
	
	private Status(String code) {
		this.key = code;
	}
	
	public String getKey() {
		return key;
	}

	public static String getAllKeys() {
		boolean first = true;
		StringBuffer str = new StringBuffer("[");
		for( Status one : Status.values() ) {
			if(first) {
				str.append(one);
				first = false;
			} else str.append(", " + one);
		}
		str.append("]");
		return str.toString();
	}
}
