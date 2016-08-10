package com.mapps.exception;

import com.mapps.utilities.Status;

public class ApplicationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8343586993793890451L;
	
	public ApplicationException() {
		super(Status.UNKNOWN.name());
	}

	public ApplicationException(Status arg0) {
		super(arg0.name());
	}
	
	public ApplicationException(String arg0) {
		super(arg0);
	}

	public ApplicationException(Throwable arg0) {
		super(Status.UNKNOWN.name(), arg0);
	}

	public ApplicationException(Status arg0, Throwable arg1) {
		super(arg0.name(), arg1);
	}
	
	public ApplicationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
