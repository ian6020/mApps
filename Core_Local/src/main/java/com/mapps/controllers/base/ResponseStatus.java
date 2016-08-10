package com.mapps.controllers.base;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.mapps.utilities.Code;
import com.mapps.utilities.Status;

public class ResponseStatus implements Serializable{

	private static final long serialVersionUID = 202918802853200800L;

	protected Status status = Status.NONE;
	protected Code code = Code.NONE;
	protected String message;
	
	public ResponseStatus() {
		
	}
	
	public ResponseStatus(Status status, Code code, String msg) {
		this.status = status;
		this.code = code;
		this.message = msg;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}
	
	public String toString() {
		return new ToStringBuilder(this).append("Status", status)
				.append("Code", code).append("Message", message).toString();
	}
	
}
