package com.mapps.exception;

import com.mapps.utilities.Code;
import com.mapps.utilities.Status;

/**
 * {@link RuntimeException} used by the service layer.
 *
 */
public class ServiceException extends ApplicationException
{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 9165930277144951860L;

	public ServiceException(Code code) {
		this(Status.UNKNOWN, code);
	}

	public ServiceException(Status arg0, Code code) {
		super(arg0.name() + " [" + code.name() + "]");
	}

	public ServiceException(Code code, Throwable arg0) {
		this(Status.UNKNOWN, code, arg0);
	}

	public ServiceException(Status arg0, Code code, Throwable arg1) {
		super(arg0.name() + " [" + code.name() + "]", arg1);
	}

}
