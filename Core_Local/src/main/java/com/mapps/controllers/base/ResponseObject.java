package com.mapps.controllers.base;

import com.mapps.utilities.Code;
import com.mapps.utilities.Status;

public class ResponseObject extends ResponseStatus {
	
	private Object object;

	private static final long serialVersionUID = -4655568693844214391L;

	public ResponseObject() {
		
	}
	
	public ResponseObject(Status status, Code code, String msg) {
		super(status, code, msg);
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object t) {
		object = t;
	}

}
